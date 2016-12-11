package com.maiso.alura_eclipse;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

public class OlaMundo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ola_mundo);
        Log.i("ciclos","Criado");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("ciclos","startado");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("ciclos","Resumo");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("ciclos","Pausado");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("ciclos","Parado");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("ciclos","Destruído");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("ciclos","Reinicado");
    }
}
