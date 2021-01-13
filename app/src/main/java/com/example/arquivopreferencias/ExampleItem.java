package com.example.arquivopreferencias;


import android.widget.RelativeLayout;

public class ExampleItem {
    private String nomeUsuario;
    private String emailUsuario;
    private long idUsuario;
    private String senhaUsuario;
    private RelativeLayout relativeLayout;

    public ExampleItem(String nomeUser, String emailUser,long idUser,String senhaUser){
        nomeUsuario = nomeUser;
        emailUsuario = emailUser;
        idUsuario = idUser;
        senhaUsuario = senhaUser;
    }

    public String getNomeBack(){
        return nomeUsuario;
    }

    public String getEmailBack(){
        return emailUsuario;
    }

    public long getIdBack(){ return idUsuario; }

    public String getSenhaBack(){return senhaUsuario;}

    public RelativeLayout getRelativeLayoutBack(){return relativeLayout;}
}
