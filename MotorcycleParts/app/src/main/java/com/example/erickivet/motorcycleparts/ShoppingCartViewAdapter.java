package com.example.erickivet.motorcycleparts;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.annotation.IntegerRes;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by erickivet on 8/28/16.
 */
public class ShoppingCartViewAdapter extends RecyclerView.Adapter<ShoppingCartViewHolder> {

    private static final String TAG = "ShoppingCartViewAdapter";

    private List<Products> mShoppingCart = new ArrayList<>();
    Button update;
    Button delete;
    TextView quantText;
    EditText quantEditText;
    TextView priceText;

    public ShoppingCartViewAdapter(List<Products> products){
        this.mShoppingCart = ShoppingCart.getInstance().getCartList();
    }

    @Override
    public ShoppingCartViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cart_recycler_row,parent,
                false);

        return new ShoppingCartViewHolder(v);
    }

    /*
    * Set Buttons in recyclerviews to update quantities or delete items*/

    @Override
    public void onBindViewHolder(final ShoppingCartViewHolder holder, int position) {

        final Products products = mShoppingCart.get(position);
        holder.setCartImage(products.getItemImage());
        holder.setCartName(products.getItemName());
        holder.setCartPrice(String.valueOf(products.getItemPrice()));

        quantText = (TextView) holder.itemView.findViewById(R.id.quant_display);
        update = (Button) holder.itemView.findViewById(R.id.update_button);
        priceText = (TextView) holder.itemView.findViewById(R.id.textview_price);

        View.OnClickListener updateListener = new View.OnClickListener(){
            @Override
            public void onClick(final View view){
                AlertDialog.Builder updateDialogBuilder = new AlertDialog.Builder(view.getContext());
                updateDialogBuilder.setView(R.layout.update_quant_dialog);

                updateDialogBuilder.setTitle("Update Quantity");
                updateDialogBuilder.setMessage("Please Enter a New Quantity");
                updateDialogBuilder.setPositiveButton("UPDATE", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Dialog d = (Dialog) dialog;
                        quantEditText = (EditText) d.findViewById(R.id.quant_edittext);
                        String var1 = quantEditText.getText().toString();
                        if(var1.length() > 0){
                            quantText.setText(var1);
                        }else{
                            Toast.makeText(view.getContext(),"This Can't Be Empty",Toast.LENGTH_SHORT).show();
                        }
                        Toast.makeText(view.getContext(), "Quantity Updated", Toast.LENGTH_SHORT ).show();
                    }
                });

                updateDialogBuilder.setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                AlertDialog dialog = updateDialogBuilder.create();
                dialog.show();
            }
        };
        update.setOnClickListener(updateListener);


        delete = (Button) holder.itemView.findViewById(R.id.delete_item);
        View.OnClickListener deleteListener = new View.OnClickListener(){
            @Override
            public void onClick(View view){
                mShoppingCart.remove(products);
                Toast.makeText(view.getContext(),"Item Removed", Toast.LENGTH_SHORT).show();
                notifyDataSetChanged();
            }
        };
        delete.setOnClickListener(deleteListener);

    }

    @Override
    public int getItemCount() {
        return mShoppingCart.size();
    }
}
