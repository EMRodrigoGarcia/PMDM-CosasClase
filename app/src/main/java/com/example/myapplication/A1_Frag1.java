package com.example.myapplication;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class A1_Frag1 extends Fragment {
    TextView tv;
    private A1_SharedViewModel viewModel;

    public A1_Frag1() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =  inflater.inflate(R.layout.fragment_a1__frag1, container, false);
        tv = v.findViewById(R.id.textView5);
        A1_SharedViewModel model = new ViewModelProvider(requireActivity()).get(A1_SharedViewModel.class);
        model.getColor().observe(getViewLifecycleOwner(), {colorI -> tv.setTextColor(colorI)});
        return v;
    }
}