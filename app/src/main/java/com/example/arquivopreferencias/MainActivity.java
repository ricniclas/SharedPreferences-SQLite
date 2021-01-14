package com.example.arquivopreferencias;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Preferencias preferencias;

    @Override
    protected void onResume() {
        super.onResume();

        preferencias = new Preferencias();

        final EditText nome = findViewById(R.id.inputName);
        final EditText email = findViewById(R.id.inputEmail);

        nome.setText(preferencias.SendStringBack(this,"nome"));
        email.setText(preferencias.SendStringBack(this,"email"));

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        preferencias = new Preferencias();

        final EditText nome = findViewById(R.id.inputName);
        final EditText email = findViewById(R.id.inputEmail);


        Button gravar = findViewById(R.id.btnGravar);
        gravar.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v)
            {

                boolean resultado1 = preferencias.SaveOneInfo(v.getContext(),"nome",nome.getText().toString());
                boolean resultado2 = preferencias.SaveOneInfo(v.getContext(),"email",email.getText().toString());

                if(resultado1 && resultado2)
                {
                    Toast.makeText(getBaseContext(),"Gravado com sucesso",Toast.LENGTH_SHORT).show();
                }
                else
                    {
                        Toast.makeText(getBaseContext(),"Algo deu errado",Toast.LENGTH_SHORT).show();
                    }
            }
        });


        Button limpar = (Button) findViewById(R.id.btnLimpar);
        limpar.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view)
            {
                nome.setText("");
                email.setText("");
            }

        });

        Button recuperar = (Button) findViewById(R.id.btnRecuperar);
        recuperar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                nome.setText(preferencias.SendStringBack(v.getContext(),"nome"));
                email.setText(preferencias.SendStringBack(v.getContext(),"email"));
            }
        });

        Button btnNovoUsuario = findViewById(R.id.btnNovoUsuario);
        btnNovoUsuario.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                startActivity(new Intent(MainActivity.this,NewUserActivity.class));
            }
        });
        Button btnVerUsuarios = findViewById(R.id.btnVerUsuarios);
        btnVerUsuarios.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, ViewUsers.class));
            }
        });


        Button btnFragmentos = findViewById(R.id.btnVerFragmentos);
        btnFragmentos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, AmostraFragments.class));
            }
        });

    }
}