package com.sdsmdg.hareshkh.lectureassignment;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Suyash on 31-01-2017.
 */

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MoviesViewHolder> {
    private List<Movie> movies;

    public class MoviesViewHolder extends RecyclerView.ViewHolder{
        public TextView title, tagsString, year, ratings;

        public MoviesViewHolder(View view){
            super(view);
            title = (TextView) view.findViewById(R.id.mov_crd_title);
            tagsString= (TextView) view.findViewById(R.id.mov_crd_tags);
            year = (TextView) view.findViewById(R.id.mov_crd_year);
            ratings = (TextView) view.findViewById(R.id.mov_crd_ratings_amount);
        }
    }

    public MovieAdapter(List<Movie> movies){
        this.movies = movies;
    }

    @Override
    public MoviesViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View itemView  = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.movie_card, parent, false);
        return new MoviesViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MoviesViewHolder holder, int position){
        Movie movie = movies.get(position);
        holder.title.setText(movie.getMovieName());
        holder.ratings.setText(movie.getRatings());
        holder.tagsString.setText(movie.generateStringFromTags());
    }

    @Override
    public int getItemCount(){
        return movies.size();
    }

}
