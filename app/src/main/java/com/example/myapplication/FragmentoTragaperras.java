package com.example.myapplication;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

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


    public FragmentoTragaperras() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =  inflater.inflate(R.layout.fragment_fragmento_tragaperras, container, false);
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
        String mensaje = generarTirada(v);

        int premio = generarPremio(mensaje);

        if (elManejador != null) {
            elManejador.hanPulsadoElBoton(mensaje, premio);
        }
    }

    public String generarTirada(View v) {
        String tirada = "";
        int[] nums = new int[3];

        TextView[] arr = { v.findViewById(R.id.label1), v.findViewById(R.id.label2), v.findViewById(R.id.label3)};
        ArrayList<TextView> outputViews = new ArrayList<>();
        Collections.addAll(outputViews, arr);
        for (int i = 0; i < nums.length; i++) {
            nums[i] = rand(4, 1);
        }
        System.out.println(outputViews);

        for(int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                tirada += "A ";
               TextView t = outputViews.get(i);
                t.setText("A");

            }else if (nums[i] == 2) {
                tirada += "B ";
                TextView t = outputViews.get(i);
                t.setText("B");

            }else if (nums[i] == 3) {
                tirada += "C ";
                TextView t = outputViews.get(i);
                t.setText("C");
            }
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
    public int rand(int max, int min) {
        return (int) Math.random() * (max - min + 1) + min;
    }


    CuandoPulseBotonListener elManejador;

    public void estableceManejadorEvento(CuandoPulseBotonListener manejador){
        elManejador = manejador;
    }


}