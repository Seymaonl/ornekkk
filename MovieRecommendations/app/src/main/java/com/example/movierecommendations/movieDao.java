package com.example.movierecommendations;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class movieDao {
    public ArrayList<Categories> tumFilmlerByKategoriId(VeriTabani vt, int categori_id){
        ArrayList<Movies> moviesArrayList = new ArrayList<>();

        SQLiteDatabase db = vt.getWritableDatabase();
        Cursor cu = db.rawQuery("SELECT * FROM categories , movies " +
                ", director Where movies.categori_id = categories.categori_id and movies.director_id = directors.director_id and movies.categori_id="+categori_id, null);
        while (cu.moveToNext()){
            Categories c = new Categories(cu.getInt(cu.getColumnIndex("categori_id"))
                    ,cu.getString(cu.getColumnIndex("categori_name")));
            Directors d= new Directors(cu.getInt(cu.getColumnIndex("director_id"))
            ,cu.getString(cu.getColumnIndex("director_name")));
            Movies m=new Movies(cu.getInt(cu.getColumnIndex("movie_id"))
            ,cu.getString(cu.getColumnIndex("movie_name"))
            ,cu.getInt(cu.getColumnIndex("movie_year"))
                    ,cu.getString(cu.getColumnIndex("movie_picture")),c,d);




            moviesArrayList.add(m);

        }
        return moviesArrayList;
    }
}

