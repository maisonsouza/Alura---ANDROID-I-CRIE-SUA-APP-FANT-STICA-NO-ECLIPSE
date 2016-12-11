package com.maiso.alura_eclipse;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Toast;

import com.maiso.alura_eclipse.dao.AlunoDAO;
import com.maiso.alura_eclipse.modelo.Aluno;

import java.io.Serializable;

public class Formulario extends AppCompatActivity {

    private FormularioHelper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario);
        helper = new FormularioHelper(this);

        final Aluno alunoSelecionado = (Aluno) getIntent().getSerializableExtra("alunoSelecionado");
        Toast.makeText(this,"Aluno: "+alunoSelecionado,Toast.LENGTH_SHORT).show();
        if(alunoSelecionado!=null){
            helper.colocaAlunoNoFormulario(alunoSelecionado);
        }

        final Button botao = (Button) findViewById(R.id.botao);
        botao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Aluno aluno = helper.pegaAlunoDoFormulario();
                DBHelper helper = new DBHelper(Formulario.this);
                AlunoDAO dao = new AlunoDAO(helper);
                if(alunoSelecionado != null){
                    aluno.setId(alunoSelecionado.getId());
                    botao.setText("Alterar");
                    dao.atualizar(aluno);
                    Toast.makeText(Formulario.this,"Aluno alterado: "+aluno.getNome()+"salvo",Toast.LENGTH_LONG).show();
                }else{
                    dao.insere(aluno);
                }
                helper.close();
                Toast.makeText(Formulario.this,"Aluno: "+aluno.getNome()+"salvo",Toast.LENGTH_LONG).show();
                finish();
            }
        }
        );
    }
}
