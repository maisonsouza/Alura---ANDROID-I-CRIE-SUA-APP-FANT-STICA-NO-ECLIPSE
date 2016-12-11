package com.maiso.alura_eclipse;

import android.app.Activity;
import android.widget.EditText;
import android.widget.RatingBar;

import com.maiso.alura_eclipse.modelo.Aluno;

/**
 * Created by maiso on 10/12/2016.
 */

public class FormularioHelper {

    private final EditText campoNome;
    private final EditText campoTelefone;
    private final EditText campoEndereco;
    private final EditText campoSite;
    private final RatingBar campoNota;
    private final Aluno aluno;

    public FormularioHelper(Activity activity) {
        aluno = new Aluno();
        campoNome = (EditText) activity.findViewById(R.id.editnome);
         campoTelefone = (EditText) activity.findViewById(R.id.edittelefone);
         campoEndereco = (EditText) activity.findViewById(R.id.editendereco);
         campoSite = (EditText) activity.findViewById(R.id.editsite);
         campoNota = (RatingBar) activity.findViewById(R.id.nota);
    }
    
    public Aluno pegaAlunoDoFormulario(){

        String nome = campoNome.getText().toString();
        String endereco = campoEndereco.getText().toString();
        String telefone = campoTelefone.getText().toString();
        String site = campoSite.getText().toString();
        int nota = campoNota.getProgress();


        aluno.setNome(nome);
        aluno.setEndereco(endereco);
        aluno.setTelefone(telefone);
        aluno.setSite(site);
        aluno.setNota(Double.valueOf(nota));
        
       return aluno; 
    }

    public void colocaAlunoNoFormulario(Aluno alunoSelecionado) {
        campoNome.setText(alunoSelecionado.getNome());
        campoEndereco.setText(alunoSelecionado.getEndereco());
        campoTelefone.setText(alunoSelecionado.getTelefone());
        campoSite.setText(alunoSelecionado.getSite());
        campoNota.setRating(alunoSelecionado.getNota().floatValue());
    }
}
