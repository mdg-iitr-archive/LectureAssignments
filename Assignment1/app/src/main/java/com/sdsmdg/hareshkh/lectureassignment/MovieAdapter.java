package com.sdsmdg.hareshkh.lectureassignment;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Harshit Bansal on 1/31/2017.
 */

public class MovieAdapter  extends RecyclerView.Adapter<MovieAdapter.MyViewHolder>{
    private Context mContext;
    private List<Movie> movieList;
    private ClickListener clickListener=null;

    public void setClickListener(ClickListener clickListener) {
        this.clickListener = clickListener;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title,year;
        ImageView image;
        RelativeLayout main;
        public MyViewHolder(View itemView) {
            super(itemView);
            title=(TextView)itemView.findViewById(R.id.title);
            year=(TextView)itemView.findViewById(R.id.year);
            image=(ImageView)itemView.findViewById(R.id.image);
            main=(RelativeLayout)itemView.findViewById(R.id.main);
            main.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (clickListener != null) {
                        clickListener.itemClicked(view, getAdapterPosition());
                    }
                }
            });
        }
    }

    MovieAdapter(Context mContext, List<Movie> movieList){
        this.mContext=mContext;
        this.movieList=movieList;
    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView= LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_card,parent,false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        Movie movie=movieList.get(position);
        holder.title.setText(movie.getTitle());
        holder.year.setText(movie.getYear());
        holder.image.setImageResource(movie.getImageId());

    }

    @Override
    public int getItemCount() {
        return movieList.size();
    }

}
