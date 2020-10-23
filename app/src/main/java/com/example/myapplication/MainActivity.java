package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import java.lang.reflect.Field;
import java.math.RoundingMode;
import java.text.DecimalFormat;


public class MainActivity extends AppCompatActivity {
    ViewFlipper viewFlipper;
    /*@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        viewFlipper = new ViewFlipper(this);

        int images[] = {
                R.drawable.yoshi_1,
                R.drawable.yoshi_2,
                R.drawable.yoshi_3,
                R.drawable.yoshi_4,
                R.drawable.yoshi_5,
                R.drawable.yoshi_6,
                R.drawable.yoshi_7
        };

        for(int res : images) {
            ImageView i = new ImageView(this);
            i.setImageResource(res);
            viewFlipper.addView(i);
        }

        setContentView(viewFlipper);
    }
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        viewFlipper.showNext();
        return super.onTouchEvent(event);
    }
}


