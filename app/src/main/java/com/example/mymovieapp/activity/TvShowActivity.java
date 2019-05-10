package com.example.mymovieapp.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mymovieapp.R;
import com.example.mymovieapp.model.TvShow;

public class TvShowActivity extends AppCompatActivity {

    TextView txtTvShowTitle, txtTvShowDate, txtTvShowDesc;
    ImageView imgTvShowPhoto;
    public static final String TVSHOW_PARCELABLE = "movie_parcelable";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tv_show);

        txtTvShowTitle = findViewById(R.id.tv_tvshow_title);
        txtTvShowDate = findViewById(R.id.tv_tvshow_date);
        txtTvShowDesc = findViewById(R.id.tv_tvshow_description);
        imgTvShowPhoto = findViewById(R.id.iv_img_tvshow);

        TvShow tvShow = getIntent().getParcelableExtra(TVSHOW_PARCELABLE);
        String tvShowTitle = tvShow.getTvshow_title();
        String tvShowDate = tvShow.getTvshow_date();
        String tvShowDesc = tvShow.getTvshow_description();
        int tvShowPhoto = tvShow.getTvshow_photo();

        txtTvShowTitle.setText(tvShowTitle);
        txtTvShowDate.setText(tvShowDate);
        txtTvShowDesc.setText(tvShowDesc);
        imgTvShowPhoto.setImageResource(tvShowPhoto);
    }
}
