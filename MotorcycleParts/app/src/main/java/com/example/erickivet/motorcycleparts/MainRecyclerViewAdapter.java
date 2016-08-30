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

    public MainRecyclerViewAdapter(List<Products> productsList){
        mProductsList = productsList;
    }

    @Override
    public MainRecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.main_recycler_row,parent,false);
        return new MainRecyclerViewHolder(v);
    }
    /*
    * Set database data to views set in the adapter using onBindViewHolder
    * Set On Click Listeners to deal with the user input
    */
    @Override
    public void onBindViewHolder(final MainRecyclerViewHolder holder, final int position) {
        final Products products = mProductsList.get(position);
        holder.setName(products.getItemName());
        holder.setPrice(String.valueOf(products.getItemPrice()));
        holder.setImage(products.getItemImage());


        //Create shopping cart dialog to add items to cart

        holder.itemView.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(final View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
                builder.setTitle("Add Item");
                builder.setMessage("Add Item to Shopping Cart?");
                builder.setPositiveButton("ADD",new DialogInterface.OnClickListener(){
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        ShoppingCart cart = ShoppingCart.getInstance();
                        cart.addProduct(products);
                        Toast.makeText(view.getContext(),"Item Added",Toast.LENGTH_SHORT).show();
                    }
                });
                builder.setNegativeButton("CANCEL",new DialogInterface.OnClickListener(){
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(view.getContext(),"Cancel",Toast.LENGTH_SHORT).show();
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
