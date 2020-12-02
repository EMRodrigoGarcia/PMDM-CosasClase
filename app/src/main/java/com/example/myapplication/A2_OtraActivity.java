package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class A2_OtraActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a2__otra);
        TextView tv = findViewById(R.id.labelMensaje);
        Intent i = getIntent();
        String mensaje = i.getStringExtra("mensaje1");
        
        tv.setText(mensaje);
    }

    public void clickCierra(View v) {
        finish();
    }
}