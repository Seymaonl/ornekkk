package com.example.movierecommendations;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CategoriAdapter extends RecyclerView.Adapter<CategoriAdapter.CardTasarimTutucu>{
    private Context mContext;
    private List<Categories> categoriesList;

    public CategoriAdapter(Context mContext, List<Categories> categoriesList) {
        this.mContext = mContext;
        this.categoriesList = categoriesList;
    }

    @NonNull
    @Override
    public CardTasarimTutucu onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.caterogi_card_tasarim,parent,false);
        return new CardTasarimTutucu(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CardTasarimTutucu holder, int position) {
        Categories categori = categoriesList.get(position);

        holder.textView.setText(categori.getCategori_name());
        holder.categori_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(mContext,MoviesActivity.class);

                intent.putExtra("kategori_nesne" , categori);

                mContext.startActivity(intent);

            }
        });

    }

    @Override
    public int getItemCount() {
        return categoriesList.size();
    }

    public class CardTasarimTutucu extends RecyclerView.ViewHolder{
        private CardView categori_card;
        private TextView textView;

        public CardTasarimTutucu(@NonNull View itemView) {
            super(itemView);

            categori_card = itemView.findViewById(R.id.categori_card);
            textView = itemView.findViewById(R.id.textView);
        }
    }
}
