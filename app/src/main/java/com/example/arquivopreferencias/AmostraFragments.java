package com.example.arquivopreferencias;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class AmostraFragments extends AppCompatActivity implements BlankFragment1.Fragment1Listener, BlankFragment2.Fragment2Listener {
    private BlankFragment1 fragment1;
    private BlankFragment2 fragment2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_amostra_fragments);

        fragment1 = new BlankFragment1();
        fragment2 = new BlankFragment2();

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container_1,fragment1)
                .replace(R.id.container_2,fragment2)
                .commit();
    }

    @Override
    public void onInput1Sent(CharSequence input) {
        fragment2.updateEditText(input);
    }

    @Override
    public void onInput2Sent(CharSequence input) {
        fragment1.updateEditText(input);
    }
}