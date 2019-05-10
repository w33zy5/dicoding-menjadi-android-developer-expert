/*
package com.example.mymovieapp;

import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Debug;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private String[] dataName;
    private String[] dataDescription;
    private String[] dataReleaseDate;
    private TypedArray dataPhoto;
    private MovieAdapter adapter;
    private ArrayList<Movie> movies;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        adapter = new MovieAdapter(this);

        ListView listView = findViewById(R.id.lv_movie_list);
        listView.setAdapter(adapter);

        prepare();
        addItem();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent moveWithObjectIntent = new Intent(MainActivity.this, MovieActivity.class);
                Movie movie = new Movie();
                movie.setTitle(dataName[position]);
                movie.setDescription(dataDescription[position]);
                movie.setDate(dataReleaseDate[position]);
                movie.setPhoto(dataPhoto.getResourceId(position, -1));
                Log.d("MOVIE_ITEM", "intent_setPhoto: " + dataPhoto.getResourceId(position, -1));
                moveWithObjectIntent.putExtra(MovieActivity.MOVIE_PARCELABLE, movie);
                startActivity(moveWithObjectIntent);
Toast.makeText(MainActivity.this, movies.get(position).getTitle(), Toast.LENGTH_SHORT).show();

            }
        });
    }

    private void prepare() {
        dataName = getResources().getStringArray(R.array.data_Name);
        Log.d("PREPARE", "prepare dataName: " + dataName);
        dataDescription = getResources().getStringArray(R.array.data_Description);
        Log.d("PREPARE", "prepare dataDescription: " + dataDescription);
        dataPhoto = getResources().obtainTypedArray(R.array.data_Photo);
        Log.d("PREPARE", "prepare dataPhoto: " + dataPhoto);
        dataReleaseDate = getResources().getStringArray(R.array.data_date);
    }
    private void addItem(){
        movies = new ArrayList<>();

        for(int i = 0; i < dataName.length; i++){
            Movie movie = new Movie();
            movie.setPhoto(dataPhoto.getResourceId(i, -1));
            Log.d("MOVIE_ITEM", "lv_setPhoto: " + dataPhoto.getResourceId(i, -1));
            movie.setTitle(dataName[i]);
            movie.setDescription(dataDescription[i]);
            movie.setDate(dataReleaseDate[i]);
            Log.d("ADDITEM", "addItem: " + movie);
            movies.add(movie);
        }
        adapter.setMovies(movies);
    }
}
*/
