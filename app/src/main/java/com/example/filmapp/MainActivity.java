package com.example.filmapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.StrictMode;
import android.widget.ListView;

import java.util.ArrayList;

import helpers.MovieAdapter;
import models.Movie;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //permit all the request from the thread
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);


        ListView list = (ListView)findViewById(R.id.movies_list);

        //the list for the movie
        ArrayList<Movie> moviesList = new ArrayList<>();
        moviesList.add(new Movie("https://www.myboutiquehotel.com/photos/8998/the-st-regis-bora-bora-resort-bora-bora-264-60864-1024x768.jpg",
                "MALDIVES","1936"));
        moviesList.add(new Movie("https://cache.marriott.com/marriottassets/marriott/BOBXR/bobxr-exterior-aerialview-1580-hor-wide.jpg?interpolation=progressive-bilinear&downsize=1440px:*",
                "BORA BORA",
                "2020"));

        MovieAdapter myAdapter = new MovieAdapter(MainActivity.this,moviesList);

        list.setAdapter(myAdapter);


    }
}