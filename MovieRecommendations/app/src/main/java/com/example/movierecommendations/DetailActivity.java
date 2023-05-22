package com.example.movierecommendations;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {
    private ImageView imageViewPicture;
    private TextView textViewName, textViewYear, textViewDirector;
    private Movies movie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        imageViewPicture = findViewById(R.id.imageViewPicture);
        textViewName = findViewById(R.id.textViewName);
        textViewYear = findViewById(R.id.textViewYear);
        textViewDirector = findViewById(R.id.textViewDirector);

        movie = (Movies) getIntent().getSerializableExtra("nesne");
        textViewName.setText(movie.getMovie_name());
        textViewYear.setText(String.valueOf(movie.getMovie_year()));
        textViewDirector.setText(movie.getDirector());

        imageViewPicture.setImageResource(getResources().getIdentifier(movie.getMovie_picture(),
                "drawable", getPackageName()));
    }
}