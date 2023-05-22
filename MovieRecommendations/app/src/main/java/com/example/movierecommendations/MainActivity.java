package com.example.movierecommendations;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.io.IOException;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private RecyclerView rv;
    private ArrayList<Categories> categoriesArrayList;
    private CategoriAdapter adapter;
    private VeriTabani vt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbar);
        rv = findViewById(R.id.rv);
        veritabaniKopyala();

        vt = new VeriTabani(this);

        toolbar.setTitle("Kategoriler");
        setSupportActionBar(toolbar);

        rv.setHasFixedSize(true);
        rv.setLayoutManager(new LinearLayoutManager(this));



        categoriesArrayList = new categoriDao().tumKategoriler(vt);



        adapter = new CategoriAdapter(this,categoriesArrayList);
        rv.setAdapter(adapter);


    }
    public void veritabaniKopyala(){
        Database helper = new Database(this);
        try {
            helper.createDataBase();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        helper.openDataBase();
    }
}

















