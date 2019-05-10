package com.example.mymovieapp.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.mymovieapp.R;
import com.example.mymovieapp.model.TvShow;

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
        categoryViewHolder.tvTvShowTitle.setText(getListTvshow().get(position).getTvshow_title());
        categoryViewHolder.tvTvShowReleaseDate.setText(getListTvshow().get(position).getTvshow_date());
        categoryViewHolder.tvTvShowDesc.setText(getListTvshow().get(position).getTvshow_description());

        Glide.with(context)
                .load(getListTvshow().get(position).getTvshow_photo())
                .into(categoryViewHolder.tvShowImgPhoto);
    }

    @Override
    public int getItemCount() {
        return getListTvshow().size();
    }

    class CategoryViewHolder extends RecyclerView.ViewHolder {
        private TextView tvTvShowTitle;
        private TextView tvTvShowDesc;
        private TextView tvTvShowReleaseDate;
        private ImageView tvShowImgPhoto;

        CategoryViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTvShowTitle = itemView.findViewById(R.id.tv_lv_tvshow_title);
            tvTvShowDesc = itemView.findViewById(R.id.tv_lv_tvshow_description);
            tvTvShowReleaseDate = itemView.findViewById(R.id.tv_lv_tvshow_release_date);
            tvShowImgPhoto = itemView.findViewById(R.id.iv_lv_img_tvshow);
        }
    }
}
