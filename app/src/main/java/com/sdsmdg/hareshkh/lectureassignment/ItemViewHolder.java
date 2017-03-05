package com.sdsmdg.hareshkh.lectureassignment;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by shyam on 31-Jan-17.
 */

public class ItemViewHolder extends RecyclerView.ViewHolder {
    ImageView moviePoster;
    TextView movieName;
    TextView movieReleaseDate;

    ItemViewHolder(View itemView){
        super(itemView);
        moviePoster = (ImageView) itemView.findViewById(R.id.movie_poster);
        movieName = (TextView) itemView.findViewById(R.id.movie_name);
        movieReleaseDate = (TextView) itemView.findViewById(R.id.movie_releaseDate);
    }
}
