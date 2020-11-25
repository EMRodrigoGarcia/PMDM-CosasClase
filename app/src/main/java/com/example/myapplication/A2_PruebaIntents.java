package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class A2_PruebaIntents extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a2__prueba_intents);
    }

    public void clickWeb(View v) {
        Intent i = new Intent();
        i.setAction(Intent.ACTION_VIEW);//setaction
        i.setData(Uri.parse("http://google.com"));// setdata
        //putextra
        startActivity(i);//startactivity
    }

    public void clickText(View v) {
        Intent i = new Intent();
        i.setType(Intent.ACTION_CALL);
        Uri.parse("tel:+34123456789");
        startActivity(i);
    }
}