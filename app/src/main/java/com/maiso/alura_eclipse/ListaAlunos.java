package com.maiso.alura_eclipse;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.maiso.alura_eclipse.dao.AlunoDAO;
import com.maiso.alura_eclipse.modelo.Aluno;

import java.util.List;

public class ListaAlunos extends AppCompatActivity {


    private ListView listagem;
    private Aluno aluno;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listagem_alunos);

        listagem = (ListView) findViewById(R.id.lista);
        registerForContextMenu(listagem);

        listagem.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapter, View view, int posicao, long l) {
                Aluno alunoASerAlterado = (Aluno) adapter.getItemAtPosition(posicao);
                Intent vaiproFormulario = new Intent(ListaAlunos.this, Formulario.class);
                vaiproFormulario.putExtra("alunoSelecionado",alunoASerAlterado);
                startActivity(vaiproFormulario);
            }
        });
        
        listagem.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapter, View view, int posicao, long l) {
                 aluno = (Aluno) adapter.getItemAtPosition(posicao);
                return false;
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_lista_alunos,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case R.id.menu_novo:
                Intent vaiproFormulario = new Intent(this,Formulario.class);
                startActivity(vaiproFormulario);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onResume() {
        super.onResume();
        carregaLista();
    }

    private void carregaLista() {
        DBHelper helper = new DBHelper(this);
        AlunoDAO dao = new AlunoDAO(helper);
        List<Aluno> alunos = dao.getLista();

        ArrayAdapter<Aluno> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, alunos);
        listagem.setAdapter(adapter);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        menu.add("Ligar");
        menu.add("Enviar SMS");
        menu.add("Achar no Mapa");
        menu.add("Navegar no Site");
        MenuItem deletar = menu.add("Deletar");
        deletar.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                DBHelper helper = new DBHelper(ListaAlunos.this);
                AlunoDAO dao = new AlunoDAO(helper);
                dao.deletar(aluno);
                helper.close();
                carregaLista();
                return false;
            }
        });

    }

}
