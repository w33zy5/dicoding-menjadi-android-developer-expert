package com.example.mymovieapp;


import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class TvShowFragment extends Fragment {
    private RecyclerView rvTvShowCategory;
    private RvListTvShowAdapter rvListTvShowAdapter;
    private ArrayList<TvShow> tvShowList = new ArrayList<>();
    private String[] dataTvShowName;
    private String[] dataTvShowDescription;
    private String[] dataTvShowReleaseDate;
    private TypedArray dataTvShowPhoto;


    public TvShowFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_tv_show, container, false);

        rvTvShowCategory = view.findViewById(R.id.rv_tvshow);
        rvTvShowCategory.setHasFixedSize(true);

        showRecyclerList();
        loadItem();
        addItem();

        return view;
    }

    private void addItem() {
        tvShowList = new ArrayList<>();

        for(int i = 0; i < dataTvShowName.length; i++){
            TvShow tvShow = new TvShow();
            tvShow.setTvshow_photo(dataTvShowPhoto.getResourceId(i, -1));
            tvShow.setTvshow_title(dataTvShowName[i]);
            tvShow.setTvshow_date(dataTvShowReleaseDate[i]);
            tvShow.setTvshow_description(dataTvShowDescription[i]);
            tvShowList.add(tvShow);
        }
        rvListTvShowAdapter.setListTvshow(tvShowList);
    }

    private void loadItem() {
        dataTvShowName = getResources().getStringArray(R.array.tvshow_data_name);
        dataTvShowDescription = getResources().getStringArray(R.array.tvshow_data_description);
        dataTvShowReleaseDate = getResources().getStringArray(R.array.tvshow_data_date);
        dataTvShowPhoto = getResources().obtainTypedArray(R.array.tvshow_data_photo);
    }

    private void showRecyclerList() {
        rvTvShowCategory.setLayoutManager(new LinearLayoutManager(getActivity()));
        rvListTvShowAdapter = new RvListTvShowAdapter(getActivity());
        rvTvShowCategory.setAdapter(rvListTvShowAdapter);
    }

}
