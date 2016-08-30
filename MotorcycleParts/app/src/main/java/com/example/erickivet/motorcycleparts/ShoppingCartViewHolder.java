package com.example.erickivet.motorcycleparts;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * Created by erickivet on 8/28/16.
 */
public class ShoppingCartViewHolder extends RecyclerView.ViewHolder {

    ImageView itemImageView;
    TextView titleTextView;
    TextView priceTextView;
    TextView quantTextView;
    TextView quantDisplay;
    EditText quantityEditText;
    Button updateButton;
    Button deleteButton;

    public ShoppingCartViewHolder(View itemView) {
        super(itemView);

        itemImageView = (ImageView)itemView.findViewById(R.id.imageview_cart);
        titleTextView = (TextView)itemView.findViewById(R.id.textview_cart);
        priceTextView = (TextView)itemView.findViewById(R.id.textview_price_cart);
        quantTextView = (TextView)itemView.findViewById(R.id.quantity_textview);
        quantDisplay = (TextView)itemView.findViewById(R.id.quant_display);
        updateButton = (Button)itemView.findViewById(R.id.update_button);
        deleteButton = (Button)itemView.findViewById(R.id.delete_item);

    }

    public void setCartName(String title){
        titleTextView.setText(title);
    }

    public void setCartPrice(String price){
        priceTextView.setText(price);
    }

    public void setCartImage(int image){
        itemImageView.setImageResource(image);
    }

    public void setCartQuantity(String quant){quantityEditText.setText(quant);}
}
