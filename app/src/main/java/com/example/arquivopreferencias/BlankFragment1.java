package com.example.arquivopreferencias;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link BlankFragment1#newInstance} factory method to
 * create an instance of this fragment.
 *
 */
public class BlankFragment1 extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER

    private Fragment1Listener listener;
    private EditText etMensagem;
    private Button btnMensagem;
    public interface Fragment1Listener{
        void onInput1Sent(CharSequence input);
    }

    // TODO: Rename and change types of parameters


    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment BlankFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static BlankFragment1 newInstance(String param1, String param2) {
        BlankFragment1 fragment = new BlankFragment1();
        Bundle args = new Bundle();

        fragment.setArguments(args);

        return fragment;
    }

    public BlankFragment1() {
        // Required empty public constructor

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {


        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_1,container,false);
        etMensagem = v.findViewById(R.id.eTFragmentMensagem1);
        btnMensagem = v.findViewById(R.id.btnFragmentEnviar1);

        btnMensagem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CharSequence input = etMensagem.getText();
                listener.onInput1Sent(input);
            }
        });

        return v;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof Fragment1Listener){
            listener = (Fragment1Listener) context;
        }else {
            throw new RuntimeException(context.toString()+" must implement Frag1Listener");
        }
    }

    public void updateEditText(CharSequence newText){
        etMensagem.setText(newText);
    }

    @Override
    public void onDetach() {
        super.onDetach();
        listener = null;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


    }
}