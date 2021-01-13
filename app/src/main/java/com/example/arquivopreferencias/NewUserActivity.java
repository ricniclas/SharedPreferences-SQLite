package com.example.arquivopreferencias;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class NewUserActivity extends AppCompatActivity {
    private Usuario usuario = new Usuario();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_user);

        final EditText edNome = findViewById(R.id.edNome);
        final EditText edEmail = findViewById(R.id.edEmail);
        final EditText edSenha = findViewById(R.id.edSenha);

        final Button btnSalvar = findViewById(R.id.btnSalvar);

        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                usuario.setNome(edNome.getText().toString());
                usuario.setEmail(edEmail.getText().toString());
                usuario.setSenha(edSenha.getText().toString());

                BancoDeDados bd = new BancoDeDados(getBaseContext());
                bd.inserir(usuario);

                Toast.makeText(getBaseContext(), "Usuário inserido com sucesso",Toast.LENGTH_SHORT).show();
            }
        });
        final Button btnEditar = findViewById(R.id.btnEditar);
        btnEditar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                usuario.setNome(edNome.getText().toString());
                usuario.setEmail(edEmail.getText().toString());
                usuario.setSenha(edSenha.getText().toString());

                BancoDeDados bancoDeDados = new BancoDeDados(getBaseContext());
                bancoDeDados.atualizar(usuario);
            }});

        final Button btnDebugar = findViewById(R.id.btnDebugar);
        btnDebugar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BancoDeDados bancoDeDados = new BancoDeDados(getBaseContext());
                bancoDeDados.debugar();
            }
        });
    }
}