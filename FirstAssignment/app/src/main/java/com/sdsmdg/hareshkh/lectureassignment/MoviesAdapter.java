package com.sdsmdg.hareshkh.lectureassignment;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class MoviesAdapter  extends RecyclerView.Adapter<MoviesAdapter.MyViewHolder>
{
    private List<Movie> moviesList;

    @Override
    public MoviesAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
View itemview= LayoutInflater.from(parent.getContext()).inflate(R.layout.layout,parent, false);
    return new MyViewHolder(itemview);
    }


    @Override
    public void onBindViewHolder(MoviesAdapter.MyViewHolder holder, int position)
    {

        Movie movie = moviesList.get(position);
        holder.name.setText(movie.getName());
        holder.year.setText(movie.getYear());

    }

    @Override
    public int getItemCount() {
        return moviesList.size();
    }
    public MoviesAdapter(List<Movie> moviesList) {
        this.moviesList = moviesList;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder
    {
        public TextView name,year;
        public ImageView imageView;

        public MyViewHolder(View itemView) {
            super(itemView);
            imageView= (ImageView) itemView.findViewById(R.id.image);
            name= (TextView) itemView.findViewById(R.id.name);
            year= (TextView) itemView.findViewById(R.id.year);

        }
        }
}
