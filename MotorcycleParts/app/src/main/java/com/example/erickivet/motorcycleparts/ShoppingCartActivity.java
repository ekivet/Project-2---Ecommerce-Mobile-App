package com.example.erickivet.motorcycleparts;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import java.util.List;

public class ShoppingCartActivity extends AppCompatActivity {

    RecyclerView mRecyclerView;
    ShoppingCart mShoppingCart;

    ShoppingCartViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shopping_cart_activity);

        mShoppingCart = ShoppingCart.getInstance();

        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerview_cart_activity);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false);
        mRecyclerView.setLayoutManager(layoutManager);

        adapter = new ShoppingCartViewAdapter(mShoppingCart.getCartList());
        mRecyclerView.setAdapter(adapter);

        if (mShoppingCart.getCartList().size() == 0){
            Toast.makeText(mRecyclerView.getContext(),"Cart Is Empty",Toast.LENGTH_LONG).show();
        }

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab_cart);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mShoppingCart.getCartList().size() > 0) {
                    mShoppingCart.clearCart();
                    Snackbar.make(view, "Thank You!  You've checked out.", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                }else{
                    Snackbar.make(view,"Cart Is Empty",Snackbar.LENGTH_LONG).setAction("Action",null).show();
                }
            }
        });
    }

}

