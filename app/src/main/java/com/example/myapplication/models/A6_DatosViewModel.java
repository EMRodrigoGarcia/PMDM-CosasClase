package com.example.myapplication.models;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class A6_DatosViewModel extends ViewModel {
    private static final String RSS_URL = "https://www.rtve.es/api/tematicas/129647/noticias.rss";
    private MutableLiveData<String> datos;

    public  LiveData<String> getDatos () {
        if (this.datos == null) {
            datos = new MutableLiveData<>("");
            setDatos();
        }
        return datos;
    }

    private void setDatos() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    StringBuffer buffer = new StringBuffer();
                    URL url = new URL(RSS_URL);
                    HttpURLConnection urlConexion = (HttpURLConnection) url.openConnection();
                    String aux = "";

                    BufferedReader lector = new BufferedReader(new InputStreamReader(urlConexion.getInputStream()));

                    while ((aux = lector.readLine()) != null) {
                        buffer.append(aux);
                    }

                    datos.postValue(buffer.toString());
                    urlConexion.disconnect();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
