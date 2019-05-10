package com.example.mymovieapp.fragment;


import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mymovieapp.R;
import com.example.mymovieapp.activity.MovieActivity;
import com.example.mymovieapp.adapter.RvListMovieAdapter;
import com.example.mymovieapp.listener.ItemClickSupport;
import com.example.mymovieapp.model.Movie;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class MovieFragment extends Fragment {
    private RecyclerView rvMovieCategory;
    private RvListMovieAdapter rvListMovieAdapter;
    private ArrayList<Movie> movieList = new ArrayList<>();
    private String[] dataName;
    private String[] dataDescription;
    private String[] dataReleaseDate;
    private TypedArray dataPhoto;

    public MovieFragment() {
        // Required empty public constructor

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_movie, container, false);

        rvMovieCategory = view.findViewById(R.id.rv_movie);
        rvMovieCategory.setHasFixedSize(true);

        showRecyclerList();
        loadItem();
        addItem();

        return view;
    }

    private void loadItem() {
        dataName = getResources().getStringArray(R.array.data_Name);
        Log.d("PREPARE", "prepare dataName: " + dataName);
        dataDescription = getResources().getStringArray(R.array.data_Description);
        Log.d("PREPARE", "prepare dataDescription: " + dataDescription);
        dataPhoto = getResources().obtainTypedArray(R.array.data_Photo);
        Log.d("PREPARE", "prepare dataPhoto: " + dataPhoto);
        dataReleaseDate = getResources().getStringArray(R.array.data_date);
    }
    private void addItem(){
        movieList = new ArrayList<>();

        for(int i = 0; i < dataName.length; i++){
            Movie movie = new Movie();
            movie.setPhoto(dataPhoto.getResourceId(i, -1));
            Log.d("MOVIE_ITEM", "lv_setPhoto: " + dataPhoto.getResourceId(i, -1));
            movie.setTitle(dataName[i]);
            movie.setDescription(dataDescription[i]);
            movie.setDate(dataReleaseDate[i]);
            Log.d("ADDITEM", "addItem: " + movie);
            movieList.add(movie);
        }

        rvListMovieAdapter.setListMovie(movieList);
    }

    private void showRecyclerList() {
        rvMovieCategory.setLayoutManager(new LinearLayoutManager(getActivity()));
        rvListMovieAdapter = new RvListMovieAdapter(getActivity());
        rvMovieCategory.setAdapter(rvListMovieAdapter);

        ItemClickSupport.addTo(rvMovieCategory).setOnItemClickListener(new ItemClickSupport.OnItemClickListener() {
            @Override
            public void onItemClicked(RecyclerView recyclerView, int position, View v) {
                Intent moveWithObjectIntent = new Intent(getActivity(), MovieActivity.class);
                Movie movie = new Movie();
                movie.setTitle(dataName[position]);
                movie.setDescription(dataDescription[position]);
                movie.setDate(dataReleaseDate[position]);
                movie.setPhoto(dataPhoto.getResourceId(position, -1));
                Log.d("MOVIE_ITEM", "intent_setPhoto: " + dataPhoto.getResourceId(position, -1));
                moveWithObjectIntent.putExtra(MovieActivity.MOVIE_PARCELABLE, movie);
                startActivity(moveWithObjectIntent);
            }
        });
    }
}
