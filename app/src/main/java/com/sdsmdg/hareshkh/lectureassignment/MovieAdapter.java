package com.sdsmdg.hareshkh.lectureassignment;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by Jaskirat on 03-02-2017.
 */

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MyViewHolder>
{
    private Context mContext;
    private List<Movie> movieList;
    private String line;

    public class MyViewHolder extends RecyclerView.ViewHolder
    {
        public TextView genre, name, year;
        public ImageView thumbnail;

        public MyViewHolder(View view)
        {
            super(view);
            name = (TextView) view.findViewById(R.id.title);
            year = (TextView) view.findViewById(R.id.yr);
            genre= (TextView) view.findViewById(R.id.gen);
            thumbnail = (ImageView) view.findViewById(R.id.thumbnail);
        }
    }

    public MovieAdapter(Context mContext, List<Movie> movieList) {
        this.mContext = mContext;
        this.movieList = movieList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.movie_card, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position)
    {
        Movie movie = movieList.get(position);
        holder.name.setText(movie.getName());
        holder.year.setText(movie.getYear());
        holder.genre.setText(movie.getGenre());


        Bitmap bitmap,scaled;
        Drawable drawable;

        switch(movie.getImg())
        {
            case ((int) R.drawable.grey): drawable = ContextCompat.getDrawable(mContext, R.drawable.grey);
                                          bitmap = ((BitmapDrawable)drawable).getBitmap();
                                          scaled=Bitmap.createScaledBitmap(bitmap,180,180,false);
                                          holder.thumbnail.setImageBitmap(scaled);
                                          break;

            case ((int) R.drawable.shawshank): drawable = ContextCompat.getDrawable(mContext, R.drawable.shawshank);
                bitmap = ((BitmapDrawable)drawable).getBitmap();
                scaled=Bitmap.createScaledBitmap(bitmap,180,180,false);
                holder.thumbnail.setImageBitmap(scaled);
                break;

            case ((int) R.drawable.joker): drawable = ContextCompat.getDrawable(mContext, R.drawable.joker);
                bitmap = ((BitmapDrawable)drawable).getBitmap();
                scaled=Bitmap.createScaledBitmap(bitmap,180,180,false);
                holder.thumbnail.setImageBitmap(scaled);
                break;

            case ((int) R.drawable.dictator): drawable = ContextCompat.getDrawable(mContext, R.drawable.dictator);
                bitmap = ((BitmapDrawable)drawable).getBitmap();
                scaled=Bitmap.createScaledBitmap(bitmap,180,180,false);
                holder.thumbnail.setImageBitmap(scaled);
                break;

            case ((int) R.drawable.wolf): drawable = ContextCompat.getDrawable(mContext, R.drawable.wolf);
                bitmap = ((BitmapDrawable)drawable).getBitmap();
                scaled=Bitmap.createScaledBitmap(bitmap,180,180,false);
                holder.thumbnail.setImageBitmap(scaled);
                break;

            case ((int) R.drawable.lala): drawable = ContextCompat.getDrawable(mContext, R.drawable.lala);
                bitmap = ((BitmapDrawable)drawable).getBitmap();
                scaled=Bitmap.createScaledBitmap(bitmap,180,180,false);
                holder.thumbnail.setImageBitmap(scaled);
                break;

            case ((int) R.drawable.titanic): drawable = ContextCompat.getDrawable(mContext, R.drawable.titanic);
                bitmap = ((BitmapDrawable)drawable).getBitmap();
                scaled=Bitmap.createScaledBitmap(bitmap,180,180,false);
                holder.thumbnail.setImageBitmap(scaled);
                break;

            case ((int) R.drawable.godfather): drawable = ContextCompat.getDrawable(mContext, R.drawable.godfather);
                bitmap = ((BitmapDrawable)drawable).getBitmap();
                scaled=Bitmap.createScaledBitmap(bitmap,180,180,false);
                holder.thumbnail.setImageBitmap(scaled);
                break;

            case ((int) R.drawable.happyness): drawable = ContextCompat.getDrawable(mContext, R.drawable.happyness);
                bitmap = ((BitmapDrawable)drawable).getBitmap();
                scaled=Bitmap.createScaledBitmap(bitmap,180,180,false);
                holder.thumbnail.setImageBitmap(scaled);
                break;
        }


        // loading album cover using Glide library
        //Glide.with(mContext).load(movie.getImg()).into(holder.thumbnail);


        holder.thumbnail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                holder.itemView.performClick();
            }
        });

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                line= (String) holder.name.getText();
                line+=" was clicked";

                Toast toast=Toast.makeText(mContext, line, Toast.LENGTH_SHORT);
                if(toast!=null)
                    toast.show();
            }
        });
    }

    @Override
    public int getItemCount()
    {
        return movieList.size();
    }

}
