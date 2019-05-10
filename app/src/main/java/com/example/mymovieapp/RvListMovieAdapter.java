package com.example.mymovieapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class RvListMovieAdapter extends RecyclerView.Adapter<RvListMovieAdapter.CategoryViewHolder>{
    private Context context;
    private ArrayList<Movie> listMovie;

    public RvListMovieAdapter(Context context) {
        this.context = context;
    }

    public ArrayList<Movie> getListMovie() {
        return listMovie;
    }

    public void setListMovie(ArrayList<Movie> listMovie) {
        this.listMovie = listMovie;
    }

    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View itemMovieRow = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_movie, viewGroup, false);
        return new CategoryViewHolder(itemMovieRow);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder categoryViewHolder, int position) {
        categoryViewHolder.tvMovieTitle.setText(getListMovie().get(position).getTitle());
        categoryViewHolder.tvMovieDesc.setText(getListMovie().get(position).getDescription());
        categoryViewHolder.tvReleaseDate.setText(getListMovie().get(position).getDate());

        Glide.with(context)
                .load(getListMovie().get(position).getPhoto())
                .into(categoryViewHolder.imgPhoto);
    }

    @Override
    public int getItemCount() {
        return getListMovie().size();
    }

    class CategoryViewHolder extends RecyclerView.ViewHolder {
        private TextView tvMovieTitle;
        private TextView tvMovieDesc;
        private TextView tvReleaseDate;
        private ImageView imgPhoto;

        CategoryViewHolder(@NonNull View itemView) {
            super(itemView);
            tvMovieTitle = itemView.findViewById(R.id.tv_lv_movie_title);
            tvReleaseDate = itemView.findViewById(R.id.tv_lv_release_date);
            tvMovieDesc = itemView.findViewById(R.id.tv_lv_description);
            imgPhoto = itemView.findViewById(R.id.iv_lv_img_movie);
        }
    }
}
