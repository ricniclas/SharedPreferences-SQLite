package com.example.arquivopreferencias;

public class Usuario {
private String nome;
private String email;
private String senha;
private long id;

public String getNome(){return  nome;}

public void setNome(String novoNome){this.nome = novoNome;}

public String getEmail(){return  email;}

public void setEmail(String novoEmail){this.email = novoEmail;}

public String getSenha(){return  senha;}

public void setSenha(String novaSenha){this.senha = novaSenha;}

public long getId(){return id;}

public void setId(long novoId){this.id = novoId;}
}
