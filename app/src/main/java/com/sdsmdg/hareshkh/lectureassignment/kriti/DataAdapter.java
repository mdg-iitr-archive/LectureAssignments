package com.sdsmdg.hareshkh.lectureassignment.kriti;

/**
 * Created by kriti on 1/3/17.
 */
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.sdsmdg.hareshkh.lectureassignment.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.ViewHolder> {
    private ArrayList<Movie> movies;
    private Context context;

    public DataAdapter(Context context, ArrayList<Movie> movies) {
        this.context = context;
        this.movies = movies;

    }

    @Override
    public DataAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row_layout, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {

        viewHolder.title.setText(movies.get(i).getMovie_name());
        viewHolder.year.setText(movies.get(i).getMovie_year());
        Picasso.with(context).load(movies.get(i).getImage_location()).resize(180, 180).into(viewHolder.imageView);
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView title;
        TextView year;
        ImageView imageView;
        public ViewHolder(View view) {
            super(view);

            title = (TextView)view.findViewById(R.id.title);
            year = (TextView)view.findViewById(R.id.year);
            imageView = (ImageView)view.findViewById(R.id.imageView);
        }
    }
}

