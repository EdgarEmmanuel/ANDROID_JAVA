package models;

import android.graphics.Bitmap;

public class Movie {


    // Store the id of the  movie poster
    private String mImageDrawable;
    // Store the name of the movie
    private String mName;
    // Store the release date of the movie
    private String mRelease;

    // Constructor that is used to create an instance of the Movie object
    public Movie(String mImageDrawable, String mName, String mRelease) {
        this.mImageDrawable = mImageDrawable;
        this.mName = mName;
        this.mRelease = mRelease;
    }

    public String getmImageDrawable() {
        return mImageDrawable;
    }

    public void setmImageDrawable(String mImageDrawable) {
        this.mImageDrawable = mImageDrawable;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public String getmRelease() {
        return mRelease;
    }

    public void setmRelease(String mRelease) {
        this.mRelease = mRelease;
    }







}
