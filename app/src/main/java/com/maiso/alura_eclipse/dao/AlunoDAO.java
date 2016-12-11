package com.maiso.alura_eclipse.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.NonNull;

import com.maiso.alura_eclipse.DBHelper;
import com.maiso.alura_eclipse.modelo.Aluno;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by maiso on 10/12/2016.
 */

public class AlunoDAO {

    private DBHelper helper;
    private static final String TABELA = "Alunos";
    private static final int VERSÃO = 1;

    public AlunoDAO(DBHelper helper) {
       this.helper=helper;
    }

    public void insere(Aluno aluno) {
        ContentValues valores = pegaValoresAluno(aluno);
        helper.getWritableDatabase().insert(TABELA, null, valores);
    }

    @NonNull
    private ContentValues pegaValoresAluno(Aluno aluno) {
        ContentValues valores = new ContentValues();

        valores.put("nome", aluno.getNome());
        valores.put("telefone", aluno.getTelefone());
        valores.put("endereco", aluno.getEndereco());
        valores.put("site", aluno.getSite());
        valores.put("nota", aluno.getNota());
        return valores;
    }

    public List <Aluno> getLista(){
        List<Aluno> alunos = new ArrayList<Aluno>();
        String sql = "SELECT * FROM " + TABELA + ";";
        Cursor cursor = helper.getReadableDatabase().rawQuery(sql, null);
        while(cursor.moveToNext()){
            Aluno aluno = new Aluno();
            aluno.setId(cursor.getLong(cursor.getColumnIndex("id")));
            aluno.setNome(cursor.getString(cursor.getColumnIndex("nome")));
            aluno.setSite(cursor.getString(cursor.getColumnIndex("site")));
            aluno.setEndereco(cursor.getString(cursor.getColumnIndex("endereco")));
            aluno.setTelefone(cursor.getString(cursor.getColumnIndex("telefone")));
            aluno.setNota(cursor.getDouble(cursor.getColumnIndex("nota")));
           // aluno.setCaminhodaFoto(cursor.getString(cursor.getColumnIndex("caminhoFoto")));
            alunos.add(aluno);
        }
        return alunos;
    }

    public void deletar(Aluno aluno) {
        String[] args = {aluno.getId().toString()};
        helper.getWritableDatabase().delete(TABELA,"id=?",args);
    }

    public void atualizar(Aluno aluno) {
        ContentValues valores = pegaValoresAluno(aluno);
        String[] args = {aluno.getId().toString()};
        helper.getWritableDatabase().update(TABELA,valores,"id=?",args);

    }
}
