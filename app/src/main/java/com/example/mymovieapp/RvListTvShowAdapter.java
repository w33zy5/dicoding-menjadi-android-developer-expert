package com.example.mymovieapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class RvListTvShowAdapter extends RecyclerView.Adapter<RvListTvShowAdapter.CategoryViewHolder> {
    private Context context;
    private ArrayList<TvShow> listTvshow;

    public RvListTvShowAdapter(Context context) {
        this.context = context;
    }

    public ArrayList<TvShow> getListTvshow() {
        return listTvshow;
    }

    public void setListTvshow(ArrayList<TvShow> listTvshow) {
        this.listTvshow = listTvshow;
    }

    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View itemTvshowRow = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_tvshow, viewGroup, false);
        return new CategoryViewHolder(itemTvshowRow);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder categoryViewHolder, int position) {

    }

    @Override
    public int getItemCount() {
        return getListTvshow().size();
    }

    public class CategoryViewHolder extends RecyclerView.ViewHolder {
        private TextView tvTvShowTitle;
        private TextView tvTvShowDesc;
        private TextView tvTvShowReleaseDate;
        private ImageView tvShowImgPhoto;

        public CategoryViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTvShowTitle = itemView.findViewById(R.id.tv_lv_tvshow_title);
            tvTvShowDesc = itemView.findViewById(R.id.tv_lv_tvshow_description);
            tvTvShowReleaseDate = itemView.findViewById(R.id.tv_lv_tvshow_description);
            tvShowImgPhoto = itemView.findViewById(R.id.iv_lv_img_tvshow);
        }
    }
}
