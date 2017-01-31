package com.sdsmdg.hareshkh.lectureassignment.arihant.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.sdsmdg.hareshkh.lectureassignment.R;
import com.sdsmdg.hareshkh.lectureassignment.arihant.Model.MovieModel;
import java.util.List;

/**
 * Created by Arihant Jain on 1/30/2017.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private int[] movieImages = {
            R.drawable.la_la_land,
            R.drawable.moonlight,
            R.drawable.manchester,
            R.drawable.arrival,
            R.drawable.hell,
            R.drawable.deadpool,
            R.drawable.civil_wars,
            R.drawable.zootopia,
            R.drawable.rogue_one,
            R.drawable.suicide
    };
   // private Bitmap resized;
    private List<MovieModel> movieModels;
    private Context ctx;

    public RecyclerViewAdapter(List<MovieModel> movieModels,Context ctx) {
        this.movieModels = movieModels;
        this.ctx = ctx;
       // Bitmap bitmap = BitmapFactory.decodeResource(Resources.getSystem(),R.drawable.arrival);
//        resized = Bitmap.createScaledBitmap(bitmap, 100, 100, true);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(ctx);
        View row = inflater.inflate(R.layout.custom_row_item,parent,false);
       Item item = new Item(row);
        return item;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        final MovieModel movieModel = movieModels.get(position);
        ((Item)holder).itemName.setText(movieModel.getName());
        ((Item)holder).itemYear.setText(movieModel.getYear());
        ((Item)holder).itemImage.setImageResource(movieModel.getImageId());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(ctx, ""+movieModels.get(position).getName(), Toast.LENGTH_SHORT).show();
            }
        });
        Animation animation = AnimationUtils.loadAnimation(ctx, android.R.anim.slide_in_left);
        holder.itemView.startAnimation(animation);
    }

    @Override
    public int getItemCount() {
        return movieModels.size();
    }
    public class Item extends RecyclerView.ViewHolder{
        ImageView itemImage;
        TextView itemName,itemYear;
        public Item(View itemView) {
            super(itemView);
            itemImage = (ImageView)itemView.findViewById(R.id.movie_image);
            itemName = (TextView)itemView.findViewById(R.id.movie_name);
            itemYear =(TextView)itemView.findViewById(R.id.movie_year);
        }
    }
}
