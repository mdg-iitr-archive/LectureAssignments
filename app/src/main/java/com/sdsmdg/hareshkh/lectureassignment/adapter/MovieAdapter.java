package com.sdsmdg.hareshkh.lectureassignment.adapter;

import android.graphics.Bitmap;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.sdsmdg.hareshkh.lectureassignment.R;
import com.sdsmdg.hareshkh.lectureassignment.model.Movie;

import java.util.List;


public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MyViewHolder> {

    private List<Movie> movieList;

    public class MyViewHolder extends RecyclerView.ViewHolder{

        private TextView title, year;
        private ImageView poster;

        public MyViewHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.title);
            year = (TextView) itemView.findViewById(R.id.year);
            poster = (ImageView) itemView.findViewById(R.id.poster);
        }
    }

    public MovieAdapter(List<Movie> movieList) {
        this.movieList = movieList;
    }

    @Override
    public MovieAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.movies_list_row, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MovieAdapter.MyViewHolder holder, int position) {
        Movie movie = movieList.get(position);
        holder.title.setText(movie.getName());
        holder.year.setText(String.valueOf(movie.getYear()));
        //TODO: this is to set the scaled down image of the poster of the movie
//        Bitmap bm = new Bitmap();
//        holder.poster.setImageBitmap();
        holder.poster.setImageResource(movie.getPoster());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });
    }

    @Override
    public int getItemCount() {
        return movieList.size();
    }
}
