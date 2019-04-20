package com.example.mymovieapp;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import static android.content.ContentValues.TAG;

public class MovieAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<Movie> movies;

    public void setMovies(ArrayList<Movie> movies) { this.movies = movies;}

    public MovieAdapter(Context context){
        this.context = context;
        movies = new ArrayList<>();
    }

    @Override
    public int getCount() {
        return movies.size();
    }

    @Override
    public Object getItem(int position) {
        return movies.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.item_movie, parent, false);
        }
        Log.d(TAG, "getView: Test");
        ViewHolder viewHolder = new ViewHolder(convertView);
        Movie movie = (Movie) getItem(position);
        viewHolder.bind(movie);
        return convertView;
    }

    private class ViewHolder {
        private TextView txtMovieTitle;
        private TextView txtMovieDesc;
        private TextView txtReleaseDate;
        private ImageView imgPhoto;

        ViewHolder(View view){
            txtMovieTitle = view.findViewById(R.id.tv_lv_movie_title);
            txtMovieDesc = view.findViewById(R.id.tv_lv_description);
            txtReleaseDate = view.findViewById(R.id.tv_lv_release_date);
            imgPhoto = view.findViewById(R.id.iv_lv_img_movie);
        }
        void bind(Movie movie){
            txtMovieTitle.setText(movie.getTitle());
            Log.d("BIND", "bind txtMovieTitle: " + txtMovieTitle);
            txtMovieDesc.setText(movie.getDescription());
            Log.d("BIND", "bind txtMovieDescription: " + txtMovieDesc);
            txtReleaseDate.setText(movie.getDate());
            imgPhoto.setImageResource(movie.getPhoto());
            Log.d("BIND", "bind imgPhoto: " + imgPhoto);
        }
    }
}
