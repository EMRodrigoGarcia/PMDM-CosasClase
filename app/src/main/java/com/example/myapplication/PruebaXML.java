package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.ButtonBarLayout;

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
                double rand = Math.random();
                if (rand < 0.25) {
                   c = Color.RED;
                }else if (rand > 0.25 && rand < 0.5) {
                    c = Color.YELLOW;
                }else if(rand > 0.5 && rand < 0.75) {
                    c = Color.GREEN;
                }

                t.setTextColor(c);
            }
        });
    }
}