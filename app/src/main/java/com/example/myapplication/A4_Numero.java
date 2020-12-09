package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class A4_Numero extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a4__numero);

    }

    public void onClickSelectNumero(View v) {
        Button bClick = (Button) v;
        String nClick = bClick.getText().toString();
        Log.i("valorNum", "Valor: "+ nClick);
        Intent vueltaIntent = new Intent();
        vueltaIntent.putExtra("numero", Integer.parseInt(nClick));
        setResult(Activity.RESULT_OK, vueltaIntent);
        finish();
    }
}