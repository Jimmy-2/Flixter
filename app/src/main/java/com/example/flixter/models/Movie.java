package com.example.flixter.models;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Movie {
    String backdropPath;
    String posterPath;
    String title;
    String overview;


    //take in json object and read out the fields we need
    public Movie(JSONObject jsonObject) throws JSONException {
        backdropPath = jsonObject.getString("backdrop_path");
        posterPath = jsonObject.getString("poster_path");
        title = jsonObject.getString("title");
        overview = jsonObject.getString("overview");

    }

    public static List<Movie> fromJsonArray(JSONArray movieJsonArray) throws JSONException {
       List<Movie> movies = new ArrayList<>();
       for (int i = 0; i < movieJsonArray.length(); i++) {
           movies.add(new Movie(movieJsonArray.getJSONObject(i)));
       }
       return movies;
    }

    public String getBackdropPath() {
        return String.format("https://image.tmdb.org/t/p/w342/%s", backdropPath);
        //%s is where the backdropPath goes
    }

    public String getPosterPath() {
        return String.format("https://image.tmdb.org/t/p/w342/%s", posterPath);
        //%s is where the posterPath goes
    }

    public String getTitle() {
        return title;
    }

    public String getOverview() {
        return overview;
    }
}
