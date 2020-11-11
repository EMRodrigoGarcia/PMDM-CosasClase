package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.widget.TextView;

public class MaquinaTragaperras extends AppCompatActivity
        implements FragmentoTragaperras.CuandoPulseBotonListener {
    TextView labelPremio;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        labelPremio = findViewById(R.id.labelPremio);

        setContentView(R.layout.activity_maquina_tragaperras);

    }

    @Override
    public void onAttachFragment(@NonNull Fragment fragment) {
           // super.onAttachFragment(fragment);
        if (fragment instanceof FragmentoTragaperras) {
            FragmentoTragaperras frag = (FragmentoTragaperras) fragment;
            frag.estableceManejadorEvento(this);
        }
    }


    @Override
    public void hanPulsadoElBoton(String mensaje, int premio) {
        labelPremio.setText("Tirada: " + mensaje + ", Premio: " + premio);
    }
}