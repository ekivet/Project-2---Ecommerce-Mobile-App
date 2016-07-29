package com.example.erickivet.motorcycleparts;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by erickivet on 7/28/16.
 */
public class MainRecyclerViewHolder extends RecyclerView.ViewHolder{

    ImageView itemImageView;
    TextView titleTextView;
    TextView priceTextView;

    public MainRecyclerViewHolder(View itemView){
        super(itemView);

        itemImageView = (ImageView)itemView.findViewById(R.id.imageview_main);
        titleTextView = (TextView)itemView.findViewById(R.id.textview_main);
        priceTextView = (TextView)itemView.findViewById(R.id.textview_price);
    }

    public void setName(String title){
        titleTextView.setText(title);
    }

    public void setPrice(String price){
        priceTextView.setText(price);
    }

    public void setImage(int image){
        itemImageView.setImageResource(image);
    }
}
