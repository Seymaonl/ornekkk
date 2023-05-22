package com.example.movierecommendations;

import java.io.Serializable;

public class Movies implements Serializable {
    private int movie_id;
    private String movie_name;
    private int movie_year;
    private String movie_picture;
    private String categori;
    private String director;

    public Movies() {
    }

    public Movies(int movie_id, String movie_name, int movie_year, String movie_picture, String categori, String director) {
        this.movie_id = movie_id;
        this.movie_name = movie_name;
        this.movie_year = movie_year;
        this.movie_picture = movie_picture;
        this.categori = categori;
        this.director = director;
    }

    public int getMovie_id() {
        return movie_id;
    }

    public void setMovie_id(int movie_id) {
        this.movie_id = movie_id;
    }

    public String getMovie_name() {
        return movie_name;
    }

    public void setMovie_name(String movie_name) {
        this.movie_name = movie_name;
    }

    public int getMovie_year() {
        return movie_year;
    }

    public void setMovie_year(int movie_year) {
        this.movie_year = movie_year;
    }

    public String getMovie_picture() {
        return movie_picture;
    }

    public void setMovie_picture(String movie_picture) {
        this.movie_picture = movie_picture;
    }

    public String getCategori() {
        return categori;
    }

    public void setCategori(String categori) {
        this.categori = categori;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }
}
