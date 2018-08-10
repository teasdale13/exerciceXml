package com.example.kevinteasdaledube.exercicexml;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        List<Book> books = new ArrayList<Book>();

        try {
            InputStream is=getAssets().open("data.xml");
            XmlPullParserFile parser = new XmlPullParserFile();

            books.addAll(parser.getBookFromFile(is));

            //TextView tv = findViewById(R.id.textView);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (XmlPullParserException e) {
            e.printStackTrace();
        }
       RecyclerView rv = findViewById(R.id.recylerView);
       rv.setLayoutManager(new LinearLayoutManager(this));
       rv.setAdapter(new Adapter(books));




       //View v = layout.inflate(R.layout.cell_layout, rv, true);
       //LinearLayout l = (LinearLayout) findViewById(R.id.linearLayoutBook);
    }








    }

