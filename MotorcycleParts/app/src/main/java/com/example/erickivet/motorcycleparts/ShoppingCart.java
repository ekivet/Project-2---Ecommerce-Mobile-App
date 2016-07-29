package com.example.erickivet.motorcycleparts;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by erickivet on 7/27/16.
 */

public class ShoppingCart {

    private List <Products> mShoppingCart;

    public ShoppingCart(){
        mShoppingCart = new ArrayList<>();
    }

    public List<Products> getShoppingCart(){
        return mShoppingCart;
    }

}
