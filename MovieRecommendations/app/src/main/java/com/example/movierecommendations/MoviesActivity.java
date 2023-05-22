package com.example.movierecommendations;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.os.Bundle;

import java.util.ArrayList;

public class MoviesActivity extends AppCompatActivity {
    private Toolbar toolbar2;
    private RecyclerView moviesRv;
    private ArrayList<Movies> moviesArrayList;
    private MoviesAdapter adapter;
    private Categories categori;
    private VeriTabani vt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movies);

        toolbar2 = findViewById(R.id.toolbar2);
        moviesRv = findViewById(R.id.moviesRv);
        vt = new VeriTabani(this);


        categori = (Categories) getIntent().getSerializableExtra("kategori_nesne");
        toolbar2.setTitle(categori.getCategori_name());
        setSupportActionBar(toolbar2);
        moviesArrayList=new movieDao().tumFilmlerByKategoriId(vt,categori.getCategori_id());

        moviesRv.setHasFixedSize(true);
        moviesRv.setLayoutManager(new StaggeredGridLayoutManager(2,
                StaggeredGridLayoutManager.VERTICAL));




        adapter = new MoviesAdapter(this,moviesArrayList);
        moviesRv.setAdapter(adapter);
    }
}