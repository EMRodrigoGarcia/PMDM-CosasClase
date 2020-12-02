package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;
import android.widget.Button;

public class A2_PruebaIntents extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a2__prueba_intents);
        Button b1 = (Button) findViewById(R.id.button8);
        Button b2 = (Button) findViewById(R.id.button9);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickWeb(v);
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickText(v);
            }
        });
    }

    public void clickWeb(View v) {
        Intent i = new Intent();
        i.setAction(Intent.ACTION_VIEW);//setaction
        i.setData(Uri.parse("http://gnu.org"));// setdata
        startActivity(i);//startactivity
    }

    public void clickText(View v) {
         Intent i = new Intent();
         i.setType(Intent.ACTION_SENDTO);
         i.setData(Uri.parse("smsto:"));
         i.putExtra("sms_body", "Contenido");

        startActivity(i);
    }

    public void clickIntentOtra(View v) {
        Intent i = new Intent(this, A2_OtraActivity.class);
        i.putExtra("mensaje1", "Hola desde actividad 1");
        startActivity(i);
    }

    public void clickVibrar(View v) {
        Vibrator vib = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        vib.vibrate(400);
    }
}