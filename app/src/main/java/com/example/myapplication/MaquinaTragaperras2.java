package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MaquinaTragaperras2 extends AppCompatActivity
implements FragmentoTragaperras.CuandoPulseBotonListener{
    Button reiniciar;
    FragmentoTragaperras frag;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maquina_tragaperras2);

        reiniciar = findViewById(R.id.button7);

        reiniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                frag.reiniciar();
            }
        });

    }


    @Override
    public void onAttachFragment(@NonNull Fragment fragment) {
        // super.onAttachFragment(fragment);
        if (fragment instanceof FragmentoTragaperras) {

            frag = (FragmentoTragaperras) fragment;

            frag.estableceManejadorEvento(this);
        }
    }

    @Override
    public void hanPulsadoElBoton(String mensaje, int premio) {
        Toast.makeText(this, mensaje + premio, Toast.LENGTH_SHORT).show();
    }
}