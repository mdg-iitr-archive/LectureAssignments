package com.sdsmdg.hareshkh.lectureassignment;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;


/**
 * Created by samagra on 01-02-2017.
 */

public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.MyViewHolder> {
    private List<MoviesData> moviesList;
    private Context mContext;



    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        public TextView title, year;

        public ImageView image;

        public MyViewHolder(View view) {
            super(view);

            title = (TextView) view.findViewById(R.id.title);
            image = (ImageView) view.findViewById(R.id.image);
            year = (TextView) view.findViewById(R.id.year);
            view.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            final int position = getAdapterPosition();
            Toast.makeText(mContext,"Clicked Title"+ moviesList.get(position).getTitle(),Toast.LENGTH_SHORT).show();
        }
    }
    public MoviesAdapter(List<MoviesData> moviesList, Context context) {
        this.moviesList = moviesList;
        mContext = context;
    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(mContext)
                .inflate(R.layout.card_view, parent, false);
        MyViewHolder myViewHolder = new MyViewHolder(itemView);

        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        final MoviesData movie = moviesList.get(position);
        holder.title.setText(movie.getTitle());
        holder.image.setImageResource(movie.getImageResource());
        holder.year.setText(movie.getYear());

    }
    @Override
    public int getItemCount() {
        return moviesList.size();
    }



}
