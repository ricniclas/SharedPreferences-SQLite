package com.example.arquivopreferencias;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class BancoDeDados {
    private SQLiteDatabase bd;
    public BancoDeDados(Context context){
        BancoDeDadosCore auxDB = new BancoDeDadosCore(context);
        bd = auxDB.getWritableDatabase();
    }


    public void inserir(Usuario usuario){
        ContentValues valores = new ContentValues();
        valores.put("nome",usuario.getNome());
        valores.put("email",usuario.getEmail());
        valores.put("senha",usuario.getSenha());

        bd.insert("usuario",null, valores);
    }



    public void atualizar(Usuario usuario){
        ContentValues valores = new ContentValues();
        valores.put("nome",usuario.getNome());
        valores.put("email",usuario.getEmail());
        valores.put("senha",usuario.getSenha());

        bd.update("usuario",valores,"_id = ?", new String[]{""+usuario.getId()});
    }

    public void deletarUserAtual(Usuario usuario){
        bd.delete("usuario","_id ="+usuario.getId(),null);
    }

    public void deletarEspecifico(long id){
        bd.delete("usuario","_id ="+id,null);
    }

    public List<Usuario> buscar(){
        List<Usuario> list = new ArrayList<Usuario>();
        String[] colunas = new String[]{"_id","nome","email","senha"};
        Cursor cursor = bd.query("usuario", colunas,null,null,null,null,"nome ASC");

        if(cursor.getCount()>0){
            cursor.moveToFirst();

            do{
                Usuario u = new Usuario();
                u.setId(cursor.getLong(0));
                u.setNome(cursor.getString(1));
                u.setEmail(cursor.getString(2));
                u.setSenha(cursor.getString(3));
                list.add(u);
                System.out.println("Id: "+cursor.getLong(0) + " Nome: " +cursor.getString(1)+
                        " Email: "+cursor.getString(2)+" Senha: "+cursor.getString(3));
            }while (cursor.moveToNext());
        }
        return list;
    }

    public void debugar(){
        List<Usuario> list = new ArrayList<Usuario>();
        String[] colunas = new String[]{"_id","nome","email","senha"};
        Cursor cursor = bd.query("usuario", colunas,null,null,null,null,"_id ASC");

        if(cursor.getCount()>0){
            cursor.moveToFirst();

            do{
                System.out.println("Id: "+cursor.getLong(0) + " Nome: " +cursor.getString(1)+
                        " Email: "+cursor.getString(2)+" Senha: "+cursor.getString(3));
            }while (cursor.moveToNext());
        }
    }

    public Cursor devolverCursor(String orderBy){
        String[] colunas = new String[]{"_id","nome","email","senha"};
        Cursor cursor = bd.query("usuario",colunas,null,null,null,null,orderBy);
        return cursor;
    }
}
