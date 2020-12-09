package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class A4_Operacion extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a4__operacion);
    }

    public void onClickSelectOp(View v) {
        Intent vueltaIntent = new Intent();
        char op = ' ';

        switch(v.getId()) {
            case R.id.buttonNSuma:
                op = '+';
                break;
            case R.id.buttonNResta:
                op = '-';
                break;
            case R.id.buttonNMulti:
                op = '*';
                break;
            default:
                op = '/';
        }

        vueltaIntent.putExtra("op", op);

        setResult(Activity.RESULT_OK, vueltaIntent);
        finish();
    }
}