package com.example.myapplication;

import android.graphics.Color;

import androidx.annotation.NonNull;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;

public class A1_SharedViewModel extends ViewModel {
    private MutableLiveData<Integer> color = new MutableLiveData<>();

    public int getColor() {
        return color.getValue().intValue();
    }
    public void setColor(Integer color) {
        this.color.setValue(color);
    }



}
