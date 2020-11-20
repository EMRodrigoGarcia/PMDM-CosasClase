package com.example.myapplication;

import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class A1_Frag2 extends Fragment {
    Button bRojo;
    Button bVerde;
    Button bAzul;
    A1_SharedViewModel model;

    public A1_Frag2() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
    //TODO: Hacer que se comuniquen los dos fragmentos
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        model = new ViewModelProvider(requireActivity()).get(A1_SharedViewModel.class);
        bRojo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                model.setColor(Color.RED);
            }
        });
        bVerde.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                model.setColor(Color.GREEN);
            }
        });
        bAzul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                model.setColor(Color.BLUE);
            }
        });

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v =  inflater.inflate(R.layout.fragment_a1__frag2, container, false);
        bRojo = v.findViewById(R.id.botonRojo);
        bVerde = v.findViewById(R.id.botonVerde);
        bAzul = v.findViewById(R.id.botonAzul);


        return v;
    }
}