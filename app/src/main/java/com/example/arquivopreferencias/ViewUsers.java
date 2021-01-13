package com.example.arquivopreferencias;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.os.Bundle;

import java.util.ArrayList;

public class ViewUsers extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter recyclerAdapter;
    private RecyclerView.LayoutManager recyclerLayout;
    private BancoDeDados bancoDeDados;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view_usuarios);
        bancoDeDados = new BancoDeDados(this);

        Cursor cursor = bancoDeDados.devolverCursor("_id ASC");

        ArrayList<ExampleItem> exampleList = new ArrayList<>();

        if(cursor.getCount()>0){
            cursor.moveToFirst();

            do{
                exampleList.add(new ExampleItem(cursor.getString(1),cursor.getString(2),cursor.getLong(0),cursor.getString(3)));
            }while (cursor.moveToNext());
        }

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerLayout = new LinearLayoutManager(this);
        recyclerAdapter = new ExampleAdapter(exampleList);

        recyclerView.setLayoutManager(recyclerLayout);
        recyclerView.setAdapter(recyclerAdapter);

    }

}