package com.example.mymovieapp;

import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

public class MovieActivity extends AppCompatActivity {

    TextView txtTitle, txtDate, txtDesc;
    ImageView imgMoviePhoto;
    public static final String MOVIE_PARCELABLE = "movie_parcelable";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie);

        txtTitle = findViewById(R.id.tv_movie_title);
        txtDate = findViewById(R.id.tv_movie_date);
        txtDesc = findViewById(R.id.tv_movie_description);
        imgMoviePhoto = findViewById(R.id.iv_img_movie);

        Movie movie = getIntent().getParcelableExtra(MOVIE_PARCELABLE);
        String movieTitle = movie.getTitle();
        String movieDate = movie.getDate();
        String movieDesc = movie.getDescription();
        int moviePhoto = 0 + movie.getPhoto();
        Log.d("MOVIE_ITEM", "intent_moviePhoto: " + moviePhoto);
        /*int moviePhoto = movie.getPhoto();
        Log.d("INTENT", "moviePhoto: " + moviePhoto);*/

        txtTitle.setText(movieTitle);
        txtDate.setText(movieDate);
        txtDesc.setText(movieDesc);
        imgMoviePhoto.setImageResource(movie.getPhoto());
        Log.d("MOVIE_ITEM", "intent_getPhoto: " + movie.getPhoto());
    }
}
