package com.example.movierecommendations;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class VeriTabani extends SQLiteOpenHelper {

    public VeriTabani(@Nullable Context context) {
        super(context, "movies.sqlite" , null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS\"categories\" (\n" +
                "\t\"categori_id\"\tINTEGER PRIMARY KEY,\n" +
                "\t\"categori_name\"\tTEXT,\n" +
                "\tPRIMARY KEY(\"categori_id\" AUTOINCREMENT)\n" +
                ");");

        sqLiteDatabase.execSQL("CREATE TABLE \"directors\" (\n" +
                "\t\"director_id\"\tINTEGER,\n" +
                "\t\"director_name\"\tTEXT,\n" +
                "\tPRIMARY KEY(\"director_id\" AUTOINCREMENT)\n" +
                ");");

        sqLiteDatabase.execSQL("CREATE TABLE \"movies\" (\n" +
                "\t\"movie_id\"\tINTEGER,\n" +
                "\t\"movie_name\"\tTEXT,\n" +
                "\t\"movie_year\"\tINTEGER,\n" +
                "\t\"movie_picture\"\tTEXT,\n" +
                "\t\"categori_id\"\tINTEGER,\n" +
                "\t\"director_id\"\tINTEGER,\n" +
                "\tPRIMARY KEY(\"movie_id\" AUTOINCREMENT)\n" +
                ")");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS categories");
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS directors");
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS movies");
        onCreate(sqLiteDatabase);

    }
}
