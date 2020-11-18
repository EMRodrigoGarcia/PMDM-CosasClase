package com.example.myapplication;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static android.view.View.FIND_VIEWS_WITH_CONTENT_DESCRIPTION;


public class FragmentoTragaperras extends Fragment {

    TextView label1;
    TextView label2;
    TextView label3;

    public FragmentoTragaperras() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    public void reiniciar() {
        label1.setText("");
        label2.setText("");
        label3.setText("");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_fragmento_tragaperras, container, false);
        label1 = v.findViewById(R.id.labelFrag1);
        label2 = v.findViewById(R.id.labelFrag2);
        label3 = v.findViewById(R.id.labelFrag3);
        v.findViewById(R.id.button5).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                botonPulsado(v);
            }
        });
        return v;
    }

    public interface CuandoPulseBotonListener {
        public void hanPulsadoElBoton(String mensaje, int premio); // String o cualquier cosa
    }

    public void botonPulsado(View v) {
        String mensaje = "";
        mensaje = generarTirada(v);

        int premio = 0;
        premio = generarPremio(mensaje);
        if (elManejador != null && premio > 0) {
            elManejador.hanPulsadoElBoton(mensaje, premio);
        }
    }

    public String generarTirada(View v) {
        String tirada = "";
        for (int i = 0; i < 3; i++) {

            int n = rand(1, 4);
            Log.i("Random", "" + n);
            if (n == 1) {
                tirada += "A ";
            } else if (n == 2) {
                tirada += "B ";
            } else if (n == 3) {
                tirada += "C ";
            }
            colocarLabels(i, n);

        }

        return tirada;
    }


    public int generarPremio(String mensaje) {
        int premio = 0;
        String[] arrMensaje = mensaje.split(" ");
        if (arrMensaje[0].equals(arrMensaje[1]) && arrMensaje[1].equals(arrMensaje[2])) {
            if (arrMensaje[0].equals("A")) {
                premio = 100;
            } else if (arrMensaje[0].equals("B")) {
                premio = 150;
            } else if (arrMensaje[0].equals("C")) {
                premio = 200;
            }
        }
        return premio;
    }

    public int rand(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }


    CuandoPulseBotonListener elManejador;

    public void estableceManejadorEvento(CuandoPulseBotonListener manejador) {
        elManejador = manejador;
    }


    private void colocarLabels(int i, int n) {
        if (i == 0) {
            if (n == 1) {
                label1.setText("A");
            } else if (n == 2) {
                label1.setText("B");
            } else if (n == 3) {
                label1.setText("C");
            }
        } else if (i == 1) {
            if (n == 1) {
                label2.setText("A");
            } else if (n == 2) {
                label2.setText("B");
            } else if (n == 3) {
                label2.setText("C");
            }
        } else if (i == 2) {
            if (n == 1) {
                label3.setText("A");
            } else if (n == 2) {
                label3.setText("B");
            } else if (n == 3) {
                label3.setText("C");
            }
        }
    }

}