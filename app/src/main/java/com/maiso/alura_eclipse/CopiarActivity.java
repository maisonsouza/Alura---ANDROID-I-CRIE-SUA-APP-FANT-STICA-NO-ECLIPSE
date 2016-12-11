package com.maiso.alura_eclipse;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by maiso on 10/12/2016.
 */

public class CopiarActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ola_mundo);

        Button botao = (Button) findViewById(R.id.botao_copiar);
        final EditText entrada = (EditText) findViewById(R.id.campo);
        final TextView saida = (TextView) findViewById(R.id.texto);
        botao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i("OlaMundo","Botão Clicado");
                saida.setText(entrada.getText());
            }
        });
    }
}
