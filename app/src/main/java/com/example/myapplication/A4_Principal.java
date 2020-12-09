package com.example.myapplication;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class A4_Principal extends AppCompatActivity {
    private static final int codigoActividadNumero = 1;
    private static final int codigoActividadOperacion = 2;

    private int n1;
    private int n2;
    private char op;
    private int result;
    private boolean botonNPulsado;
    TextView labelN1;
    TextView labelN2;
    TextView labelOp;
    TextView labelResult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a4__principal2);
        labelN1 = findViewById(R.id.labeN1);
        labelN2 = findViewById(R.id.labelN2);
        labelOp = findViewById(R.id.labelOperacion);
        labelResult = findViewById(R.id.labelResultadoOp);

        n1 = -1;
        n2 = -1;
        op = ' ';
        result = 0;

    }

    public void onClickNumero(View v) {
        Intent i = new Intent(this, A4_Numero.class);
        botonNPulsado = v.getId() == R.id.buttonN1;
        startActivityForResult(i, codigoActividadNumero);
    }

    public void onClickOp(View v) {
        Intent i = new Intent(this, A4_Operacion.class);
        startActivityForResult(i, codigoActividadOperacion);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        // comprobar si recibimos un numero
        if (requestCode == codigoActividadNumero) {
            if (botonNPulsado) {
                n1 = data.getIntExtra("numero", 0);
            }else {
                n2 = data.getIntExtra("numero", 0);
            }

            Log.i("nValores SAFR", "N1: " + n1 + ", N2: " + n2);
        }else if (requestCode == codigoActividadOperacion) {
            if (resultCode == Activity.RESULT_OK) {
                op = data.getCharExtra("op", '+');
            }
        }
    }
}