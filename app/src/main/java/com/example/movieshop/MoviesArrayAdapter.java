package com.example.movieshop;

import android.content.Context;
import android.widget.ArrayAdapter;

import java.util.Locale;

@SuppressWarnings("rawtypes")
public class MoviesArrayAdapter extends ArrayAdapter {
    private final String[] moviesList;
    private final String[] authorsList;
    private final int[] yearPublished;

    public MoviesArrayAdapter(Context thisContext, int resource, String[] moviesList, String[] authorsList,int[] yearPublished) {
        super(thisContext, resource);
        this.moviesList = moviesList;
        this.authorsList = authorsList;
        this.yearPublished = yearPublished;
    }

    @Override
    public Object getItem(int position) {
        String oneMovie = moviesList[position];
        String oneAuthor = authorsList[position];
        int yearPublish = yearPublished[position];
        return oneMovie.toUpperCase(Locale.ROOT) + "\nBy:" + oneAuthor+"\nNovel Published:"+yearPublish;
    }

    @Override
    public int getCount() {
        return moviesList.length;
    }
}