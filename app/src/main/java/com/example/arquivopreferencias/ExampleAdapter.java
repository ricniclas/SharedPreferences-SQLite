package com.example.arquivopreferencias;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ExampleAdapter extends RecyclerView.Adapter<ExampleAdapter.ExampleViewHolder>{
    private ArrayList<ExampleItem> mExampleList;

    public static class ExampleViewHolder extends RecyclerView.ViewHolder{
        private TextView nomeView;
        private TextView emailView;
        private Button btnExcluir;
        private Button btnLogar;
        private EditText etSenha;
        private long idOculto;
        private String senhaOculta;
        RelativeLayout relativeLayout;


        public ExampleViewHolder(@NonNull View itemView) {
            super(itemView);
            nomeView = itemView.findViewById(R.id.nomeUsuario);
            emailView = itemView.findViewById(R.id.emailUsuario);
            btnExcluir = itemView.findViewById(R.id.btnExcluirRecycler);
            btnLogar = itemView.findViewById(R.id.btnLogarRecycler);
            etSenha = itemView.findViewById(R.id.senhaUsuario);
            relativeLayout = itemView.findViewById(R.id.relativeLayout);
        }
    }

    @NonNull
    @Override
    public ExampleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.exemple_item,parent,false);
        ExampleViewHolder evh = new ExampleViewHolder(v);
        return evh;
    }

    public ExampleAdapter (ArrayList<ExampleItem> exempleList){
        mExampleList = exempleList;
    }

    @Override
    public void onBindViewHolder(@NonNull ExampleViewHolder holder, int position) {
        ExampleItem currentItem = mExampleList.get(position);
        holder.nomeView.setText(currentItem.getNomeBack());
        holder.emailView.setText(currentItem.getEmailBack());
        holder.idOculto = currentItem.getIdBack();
        holder.senhaOculta = currentItem.getSenhaBack();
        holder.btnExcluir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String senha = holder.etSenha.getText().toString();
                if(senha.equals(holder.senhaOculta)){
                    BancoDeDados db = new BancoDeDados(v.getContext());
                    db.deletarEspecifico(holder.idOculto);
                    Toast.makeText(v.getContext(), "Usuário deletado com sucesso",Toast.LENGTH_SHORT).show();
                    mExampleList.remove(holder.getAdapterPosition());



                }
                else {Toast.makeText(v.getContext(), "Senha incorreta",Toast.LENGTH_SHORT).show();}
            }
        });

        holder.btnExcluir.setVisibility(View.GONE);
        holder.btnLogar.setVisibility(View.GONE);
        holder.etSenha.setVisibility(View.GONE);
        holder.relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(holder.btnExcluir.getVisibility() == View.GONE){
                    holder.btnExcluir.setVisibility(View.VISIBLE);
                    holder.btnLogar.setVisibility(View.VISIBLE);
                    holder.etSenha.setVisibility(View.VISIBLE);}
                else{
                    holder.btnExcluir.setVisibility(View.GONE);
                    holder.btnLogar.setVisibility(View.GONE);
                    holder.etSenha.setVisibility(View.GONE);
                }
            }
        });
        holder.btnLogar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String senha = holder.etSenha.getText().toString();
                System.out.println("Digitada: (" +senha+ ") - Correta: ("+holder.senhaOculta+")");
                if(senha.equals(holder.senhaOculta)){
                    Preferencias preferencias = new Preferencias();
                    preferencias.SaveOneInfo(v.getContext(),"nome",holder.nomeView.getText().toString());
                    preferencias.SaveOneInfo(v.getContext(),"email",holder.emailView.getText().toString());
                    Toast.makeText(v.getContext(), "Trocou de usuario!",Toast.LENGTH_SHORT).show();
                }
                else {Toast.makeText(v.getContext(), "Senha incorreta",Toast.LENGTH_SHORT).show();}
            }
        });

    }

    @Override
    public int getItemCount() {
        return mExampleList.size();
    }

}
