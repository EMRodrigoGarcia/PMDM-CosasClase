package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.parser.Parser;
import org.jsoup.select.Elements;

import java.io.IOException;

public class A7_XML_Arrays extends AppCompatActivity {
    private static final String TAG = "XML_Arrays";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // setContentView(R.layout.activity_a7__x_m_l__arrays);

        //String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"><tests><test><id>idPrimer</id><status>statusPrimer</status></test><test><id>idSegundo</id><status>statusSegundo</status></test></tests></xml>";
        String RSS_URL =  "https://www.rtve.es/api/tematicas/129647/noticias.rss";
        Document doc = null;
        try {
            doc = Jsoup.connect(RSS_URL).parser(Parser.xmlParser()).get();
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (Element element: doc.getElementsByTag("id")) {
            Log.i(TAG, "onCreate: " + element.ownText());
        }
        for (Element element : doc.getElementsByTag("description")) {
            Log.i(TAG, "description: " + element.ownText());
        }
    }
}