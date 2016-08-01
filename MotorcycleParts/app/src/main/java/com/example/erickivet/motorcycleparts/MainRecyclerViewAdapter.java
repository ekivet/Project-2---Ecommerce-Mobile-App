package com.example.erickivet.motorcycleparts;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.List;
import android.content.Context;
import android.widget.Toast;

/**
 * Created by erickivet on 7/28/16.
 */
public class MainRecyclerViewAdapter extends RecyclerView.Adapter<MainRecyclerViewHolder> {
    List<Products> mProductsList;
    Context context;

    public MainRecyclerViewAdapter(List<Products> productsList){
        mProductsList = productsList;
    }

    @Override
    public MainRecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.main_recycler_row,parent,false);
        return new MainRecyclerViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final MainRecyclerViewHolder holder, final int position) {
        Products products = mProductsList.get(position);
        holder.setName(products.getItemName());
        holder.setPrice(String.valueOf(products.getItemPrice()));
        holder.setImage(products.getItemImage());

        holder.itemView.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(final View view) {
                //Toast.makeText(view.getContext(), "You clicked this " + position, Toast.LENGTH_SHORT).show();
                AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
                builder.setTitle("Add Item");
                builder.setMessage("Add Item to Shopping Cart?");
                builder.setPositiveButton("ADD",new DialogInterface.OnClickListener(){
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(view.getContext(),"OK",Toast.LENGTH_LONG).show();
                    }
                });
                builder.setNegativeButton("CANCEL",new DialogInterface.OnClickListener(){
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(view.getContext(),"Cancel",Toast.LENGTH_LONG).show();
                    }
                });
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return mProductsList.size();
    }
}
