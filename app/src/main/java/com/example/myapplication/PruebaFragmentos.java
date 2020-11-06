package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MotionEvent;

public class PruebaFragmentos extends AppCompatActivity {
    MiPrimerFragmento frg;

    @Override
    public void onAttachFragment(@NonNull Fragment fragment) {
        super.onAttachFragment(fragment);
        frg = (MiPrimerFragmento) fragment;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        frg.setMensaje("Pantalla tocada");
        return super.onTouchEvent(event);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prueba_fragmentos);
    }
}