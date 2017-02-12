package com.sdsmdg.hareshkh.lectureassignment.rohanbh.adapters;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.sdsmdg.hareshkh.lectureassignment.R;
import com.sdsmdg.hareshkh.lectureassignment.rohanbh.activities.ProgressBarActivity;
import com.sdsmdg.hareshkh.lectureassignment.rohanbh.modelclasses.MovieClass;
import com.sdsmdg.hareshkh.lectureassignment.rohanbh.utilities.Utils;

import java.util.List;

public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.ViewHolder> {

    private List<MovieClass> movies;
    private Context ctx;

    public MoviesAdapter(List<MovieClass> movies, Context ctx) {
        this.movies = movies;
        this.ctx = ctx;
    }

    public Context getCtx() {
        return ctx;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public TextView movieName;
        public TextView movieYear;
        public ImageView movieImage;

        public ViewHolder(View itemView) {
            super(itemView);
            movieName = (TextView) itemView.findViewById(R.id.movie_name);
            movieYear = (TextView) itemView.findViewById(R.id.movie_year);
            movieImage = (ImageView) itemView.findViewById(R.id.movie_image);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int position = getAdapterPosition();
            MovieClass movie = movies.get(position);
            Toast.makeText(getCtx(), movie.getTitle() + " clicked!", Toast.LENGTH_SHORT).show();
            Intent i=new Intent(getCtx(), ProgressBarActivity.class);
            getCtx().startActivity(i);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(getCtx());

        View movieView = inflater.inflate(R.layout.row_layout, parent, false);

        ViewHolder mHolder = new ViewHolder(movieView);
        return mHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        MovieClass movie = movies.get(position);
        holder.movieName.setText(movie.getTitle());
        holder.movieYear.setText(movie.getYear());

        Bitmap bitmap = BitmapFactory.decodeResource(getCtx().getResources(),
                Utils.getImageResourceFromString(movie.getImageResId(), getCtx()));
        Bitmap bMapScaled = Utils.scaleToFitWidth(bitmap, (int) Utils.convertToPixel(500, getCtx()));

        holder.movieImage.setImageBitmap(bMapScaled);

    }

    @Override
    public int getItemCount() {
        return movies.size();
    }
}
