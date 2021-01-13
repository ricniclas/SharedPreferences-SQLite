package com.example.arquivopreferencias;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class BancoDeDadosCore extends SQLiteOpenHelper {
    private static final String NOME_BD ="teste";
    private static final int VERSAO_BD = 6;

    public BancoDeDadosCore(@Nullable Context context) {
        super(context, NOME_BD, null, VERSAO_BD);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table usuario(_id integer primary key autoincrement, nome text not null,email text not null, senha text not null)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table usuario;");
        onCreate(db);
    }
}
