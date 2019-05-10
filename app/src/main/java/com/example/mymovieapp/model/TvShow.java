package com.example.mymovieapp.model;


import android.os.Parcel;
import android.os.Parcelable;

public class TvShow implements Parcelable {
    private String tvshow_title;
    private String tvshow_description;
    private String tvshow_date;
    private int tvshow_photo;

    public String getTvshow_title() {
        return tvshow_title;
    }

    public void setTvshow_title(String tvshow_title) {
        this.tvshow_title = tvshow_title;
    }

    public String getTvshow_description() {
        return tvshow_description;
    }

    public void setTvshow_description(String tvshow_description) {
        this.tvshow_description = tvshow_description;
    }

    public String getTvshow_date() {
        return tvshow_date;
    }

    public void setTvshow_date(String tvshow_date) {
        this.tvshow_date = tvshow_date;
    }

    public int getTvshow_photo() {
        return tvshow_photo;
    }

    public void setTvshow_photo(int tvshow_photo) {
        this.tvshow_photo = tvshow_photo;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.tvshow_title);
        dest.writeString(this.tvshow_description);
        dest.writeString(this.tvshow_date);
        dest.writeInt(this.tvshow_photo);
    }

    public TvShow() {
    }

    protected TvShow(Parcel in) {
        this.tvshow_title = in.readString();
        this.tvshow_description = in.readString();
        this.tvshow_date = in.readString();
        this.tvshow_photo = in.readInt();
    }

    public static final Parcelable.Creator<TvShow> CREATOR = new Parcelable.Creator<TvShow>() {
        @Override
        public TvShow createFromParcel(Parcel source) {
            return new TvShow(source);
        }

        @Override
        public TvShow[] newArray(int size) {
            return new TvShow[size];
        }
    };
}
