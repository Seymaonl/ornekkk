package com.example.movierecommendations;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class categoriDao {

    public ArrayList<Categories> tumKategoriler(VeriTabani vt){
        ArrayList<Categories> categoriesArrayList = new ArrayList<>();

        SQLiteDatabase db = vt.getWritableDatabase();
        Cursor cu = db.rawQuery("SELECT * FROM categories",null);
        while (cu.moveToNext()){
            Categories c = new Categories(cu.getInt(cu.getColumnIndex("categori_id"))
                    ,cu.getString(cu.getColumnIndex("categori_name")));

            categoriesArrayList.add(c);

        }
        return categoriesArrayList;
    }
}
