package com.example.myapplication;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;


public class A3_FragmentoJuego extends Fragment {

    TextView labelDescubrir;
   // String[] palabras = {"hola", "perro", "botella"};
    String palabras = "hola";
    String palabraADescubrir;
    StringBuilder sb;
    Toast t;
    int intentos;
    public A3_FragmentoJuego() {

    }

    public int rand(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //palabraADescubrir = palabras[rand(0, palabras.length - 1)];
        palabraADescubrir = palabras;
        intentos = 0;
        sb = new StringBuilder();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v =  inflater.inflate(R.layout.fragment_a3__fragmento_juego, container, false);
        labelDescubrir = v.findViewById(R.id.labelDescubrir);
        return v;
    }

    public void descubre(char enviado) {

        // FIXME: Arreglar algoritmo para que no te cuente para siguientes letras
        char ch = Character.toLowerCase(enviado);
        Log.i("fragJuego", "Llegado: " + enviado);

        boolean acierto = false;

        for (int i = 0; i < palabraADescubrir.length() && !acierto; i++) {
            if (ch == palabraADescubrir.charAt(i)) {
                Log.i("fragJuego", "Acierto");
                sb.insert(i, ch);
                labelDescubrir.setText(sb.toString());
                acierto = true;
            }else {
                Log.i("fragJuego", "Fallo, intentos: " + intentos);
                intentos++;
            }
        }

        if (intentos >= 10) {
            Log.i("fragJuego", "Has perdido");
            if (frag != null) {
                frag.enviarGanar(1);
            }
        }

        if (sb.toString().equalsIgnoreCase(palabraADescubrir)) {
            Log.i("fragJuego", "Has ganado");
            if (frag != null) {
                frag.enviarGanar(0);
            }
        }
    }

    public interface fragmentoEnviar {
        public void enviarGanar(int v);
    }

    fragmentoEnviar frag;

    public void setFragmentoEnviar(fragmentoEnviar frag) {
        this.frag = frag;
    }
}