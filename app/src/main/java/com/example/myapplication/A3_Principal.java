package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class A3_Principal extends AppCompatActivity
implements A3_FragmentoJuego.fragmentoEnviar{
    A3_FragmentoJuego frag;
    EditText texto;
    char aEnviar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a3__principal);
        texto = findViewById(R.id.textoEntrada);

    }

    public void clickButton(View v) {
        aEnviar = texto.getText().charAt(0);
        frag.descubre(aEnviar);
    }

    @Override
    public void onAttachFragment(@NonNull Fragment fragment) {
        super.onAttachFragment(fragment);
        if (fragment instanceof A3_FragmentoJuego) {
            frag = (A3_FragmentoJuego) fragment;
            frag.setFragmentoEnviar(this);
        }
    }


    @Override
    public void enviarGanar(int v) {
        Intent i = new Intent(this, A3_Resultado.class);

        if (v == 0) {
            i.putExtra("resultadoJuego", "Has Ganado");
        }else if (v == 1) {
            i.putExtra("resultadoJuego", "Has Perdido");
        }

        startActivity(i);
    }
}