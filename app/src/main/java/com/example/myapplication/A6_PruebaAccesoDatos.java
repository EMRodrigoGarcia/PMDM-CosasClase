package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.widget.TextView;

import com.example.myapplication.models.A6_DatosViewModel;

public class A6_PruebaAccesoDatos extends AppCompatActivity {
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a6__prueba_acceso_datos);

        tv = findViewById(R.id.textViewAccesoDatos);
        A6_DatosViewModel modelo = new ViewModelProvider(this).get(A6_DatosViewModel.class);
        modelo.getDatos().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String users) {
                tv.setText(users);
            }
        });

    }
}