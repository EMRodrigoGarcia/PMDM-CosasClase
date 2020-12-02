package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class A3_Resultado extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a3__resultado);

        TextView tv = findViewById(R.id.labelResultado);

        Intent i = getIntent();
        String mensaje = i.getStringExtra("resultadoJuego");
        tv.setText(mensaje);
    }
}