package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.myapplication.models.A7_RecyclerViewAdapter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class A7_PruebaRecyclerView extends AppCompatActivity {
    A7_RecyclerViewAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a7__prueba_recycler_view);
        String[] array = new String[]{"Titulo1", "Texto1"};
        ArrayList<String[]> datos = new ArrayList<>();

        datos.add(array);
        datos.add(array);
        datos.add(array);


        RecyclerView rcv = findViewById(R.id.rcv);
        rcv.setLayoutManager(new LinearLayoutManager(this));
        adapter = new A7_RecyclerViewAdapter(this, datos);
        rcv.setAdapter(adapter);
    }
}