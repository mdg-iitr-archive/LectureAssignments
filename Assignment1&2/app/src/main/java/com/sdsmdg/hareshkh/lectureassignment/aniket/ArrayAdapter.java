package com.sdsmdg.hareshkh.lectureassignment.aniket;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.sdsmdg.hareshkh.lectureassignment.R;
import com.sdsmdg.tastytoast.TastyToast;

import java.util.ArrayList;

/**
 * Created by DELL on 01-02-2017.
 */

public class ArrayAdapter extends RecyclerView.Adapter<ArrayAdapter.MyViewHolder> {
    public Context context;

    public ArrayList<MovieItems> movies;

    public ArrayAdapter(ArrayList<MovieItems> movies) {
        this.movies = movies;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.movie_item, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {

        holder.movie.setText(movies.get(position).getMoviename());
        holder.year.setText(movies.get(position).getMovieyear());
        holder.img.setImageResource(movies.get(position).getImageid());
        holder.cd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TastyToast.makeText(context, movies.get(position).getMoviename(),
                        Toast.LENGTH_SHORT, TastyToast.SUCCESS);

            }
        });


    }

    @Override
    public int getItemCount() {
        return movies.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder

    {
        public TextView movie;
        public TextView year;
        public ImageView img;
        public CardView cd;

        public MyViewHolder(View view) {
            super(view);
            context = view.getContext();
            img = (ImageView) view.findViewById(R.id.im);
            movie = (TextView) view.findViewById(R.id.t1);
            year = (TextView) view.findViewById(R.id.t2);
            cd = (CardView) view.findViewById(R.id.c1);

        }


    }
}
