package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class PruebaXML extends AppCompatActivity {
    TextView t;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prueba_x_m_l);

        Button b = findViewById(R.id.button);
        t = findViewById(R.id.textView);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int c = Color.BLUE;
                if (Math.random() < 0.25) {
                   c = Color.RED;
                }else if (Math.random() > 0.25 && Math.random() < 0.5) {
                    c = Color.YELLOW;
                }else if(Math.random() > 0.5 && Math.random() < 0.75) {
                    c = Color.GREEN;
                }
                t.setTextColor(c);
            }
        });
    }
}