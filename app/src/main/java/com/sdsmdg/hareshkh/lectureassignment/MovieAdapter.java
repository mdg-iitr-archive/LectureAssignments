package com.sdsmdg.hareshkh.lectureassignment;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Mohit on 1/31/2017.
 */

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieHolder> {

    private ArrayList<Movie> mMovies;
    private static MyClickListener myClickListener;

    public MovieAdapter(ArrayList<Movie> myMovies) {
        mMovies = myMovies;
    }

    public static class MovieHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView movieTitle, movieYear;
        ImageView movieImage;


        public MovieHolder(View v) {
            super(v);
            movieTitle = (TextView) v.findViewById(R.id.movie_title);
            movieYear = (TextView) v.findViewById(R.id.movie_year);
            movieImage = (ImageView) v.findViewById(R.id.movie_image);

            v.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            myClickListener.onItemClick(getLayoutPosition(), view);
        }
    }

    public void setOnItemClickListener(MyClickListener myClickListener) {
        this.myClickListener = myClickListener;
    }


    @Override
    public MovieAdapter.MovieHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.movie_item, parent, false);

        MovieHolder movieHolder = new MovieHolder(view);
        return movieHolder;
    }

    @Override
    public void onBindViewHolder(MovieAdapter.MovieHolder holder, int position) {

        holder.movieTitle.setText(mMovies.get(position).getTitle());
        holder.movieYear.setText("" + mMovies.get(position).getYear());
        holder.movieImage.setImageResource(mMovies.get(position).getImageResourceId());

    }

    @Override
    public int getItemCount() {
        return mMovies.size();
    }

    public interface MyClickListener {
        public void onItemClick(int position, View v);
    }
}
