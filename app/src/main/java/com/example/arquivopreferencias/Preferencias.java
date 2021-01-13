package com.example.arquivopreferencias;

import android.content.Context;
import android.content.SharedPreferences;



public class Preferencias {


    public boolean SaveOneInfo(Context context, String name,Object object){


        SharedPreferences prefs = context.getSharedPreferences("preferencias", Context.MODE_PRIVATE);
        SharedPreferences.Editor ed = prefs.edit();


        if(ReturnType(object,name,ed))
        {
            ed.apply();
            return true;
        }
        else{
            return false;
        }

    }

    private boolean ReturnType(Object object,String nome, SharedPreferences.Editor editor)
    {
        try{
            if(object instanceof Float){
                editor.putFloat(nome,(float)object);
                return true;
            }
        }catch (Exception e){}

        try{
            if(object instanceof String){
                editor.putString(nome,object.toString());
                return true;
            }
        }catch (Exception e){}

        try{
            if(object instanceof Boolean){
                editor.putBoolean(nome,(Boolean) object);
                return true;
            }
        }catch (Exception e){}

        try{
            if(object instanceof Integer){
                editor.putInt(nome,(int)object);
                return true;
            }
        }catch (Exception e){}

        return false;
    }


    public int SendIntBack(Context context, String key){
        SharedPreferences prefs = context.getSharedPreferences("preferencias", Context.MODE_PRIVATE);
        return  prefs.getInt(key,0);
    }

    public float SendFloatBack(Context context, String key){
        SharedPreferences prefs = context.getSharedPreferences("preferencias", Context.MODE_PRIVATE);
        return  prefs.getFloat(key,0.0f);
    }

    public String SendStringBack(Context context, String key){
        SharedPreferences prefs = context.getSharedPreferences("preferencias", Context.MODE_PRIVATE);
        return  prefs.getString(key,"Vazio");
    }
    public boolean SendBoolBack(Context context, String key){
        SharedPreferences prefs = context.getSharedPreferences("preferencias", Context.MODE_PRIVATE);
        return  prefs.getBoolean(key,false);
    }

}
