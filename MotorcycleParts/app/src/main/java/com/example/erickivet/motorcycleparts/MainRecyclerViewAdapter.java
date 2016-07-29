package com.example.erickivet.motorcycleparts;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.List;

/**
 * Created by erickivet on 7/28/16.
 */
public class MainRecyclerViewAdapter extends RecyclerView.Adapter<MainRecyclerViewHolder> {
    List<Products> mProductsList;

    public MainRecyclerViewAdapter(List<Products> productsList){
        mProductsList = productsList;
    }

    @Override
    public MainRecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.main_recycler_row,parent,false);
        return new MainRecyclerViewHolder(v);
    }

    @Override
    public void onBindViewHolder(MainRecyclerViewHolder holder, int position) {
        Products products = mProductsList.get(position);
        holder.setName(products.getItemName());
        holder.setPrice(String.valueOf(products.getItemPrice()));
        holder.setImage(products.getItemImage());
        /**
        holder.itemView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                mProductsList.
            }
        });
         */
    }

    @Override
    public int getItemCount() {
        return mProductsList.size();
    }
}
