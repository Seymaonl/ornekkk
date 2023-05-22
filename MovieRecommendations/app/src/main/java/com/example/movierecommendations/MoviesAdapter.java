package com.example.movierecommendations;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;


public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.CardTasarimTutucu> {
        private Context mContext;
        private List<Movies> moviesList;

        public MoviesAdapter(Context mContext, List<Movies> moviesList) {
            this.mContext = mContext;
            this.moviesList = moviesList;
        }

        @NonNull
        @Override
        public CardTasarimTutucu onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_card_tasarim,parent,false);
            return new CardTasarimTutucu(view);
        }

        @Override
        public void onBindViewHolder(@NonNull CardTasarimTutucu holder, int position) {
            Movies movie = moviesList.get(position);

            holder.textView2.setText(movie.getMovie_name());
            holder.imageviewa.setImageResource(mContext.getResources().getIdentifier(movie.getMovie_picture(),
                    "drawable", mContext.getPackageName()));

            holder.movie_card.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(mContext,DetailActivity.class);

                    intent.putExtra("nesne",movie);
                    mContext.startActivity(intent);

                }
            });

        }

        @Override
        public int getItemCount() {
            return moviesList.size();
        }

        public class CardTasarimTutucu extends RecyclerView.ViewHolder{
            private CardView movie_card;
            private TextView textView2;
            private ImageView imageviewa;

            public CardTasarimTutucu(@NonNull View itemView) {
                super(itemView);

                movie_card = itemView.findViewById(R.id.movie_card);
                textView2 = itemView.findViewById(R.id.textView2);
                imageviewa = itemView.findViewById(R.id.imageviewa);
            }
        }
    }

