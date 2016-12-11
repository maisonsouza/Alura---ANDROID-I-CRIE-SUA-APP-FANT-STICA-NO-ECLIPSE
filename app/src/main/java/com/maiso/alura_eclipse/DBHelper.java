package com.maiso.alura_eclipse;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by maiso on 10/12/2016.
 */

public class DBHelper extends SQLiteOpenHelper {



        private static final String DATABASE = "DB";
        private static final int VERSAO = 1;
        private static final String TABELA = "Alunos";

        public DBHelper(Context context) {
            super(context, DATABASE, null, VERSAO);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            String sql = "CREATE TABLE " + TABELA + " ("
                    + "id INTEGER PRIMARY KEY, " + "nome TEXT UNIQUE NOT NULL, "
                    + "site TEXT, " + "endereco TEXT, " + "telefone TEXT, "
                    + "nota REAL" + ");";
            db.execSQL(sql);

        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            String sql = "DROP TABLE " + TABELA + ";";
            db.execSQL(sql);
            onCreate(db);

        }

        public static String getTabela() {
            return TABELA;
        }
}
