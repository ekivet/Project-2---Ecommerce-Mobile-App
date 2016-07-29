package com.example.erickivet.motorcycleparts;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by erickivet on 7/27/16.
 */
public class ShoppingCartSingleton {

    private static ShoppingCartSingleton mShoppingCartSingleton = null;
    private static List <ShoppingCart> mShoppingCartList;

    private ShoppingCartSingleton(){
        mShoppingCartList = new ArrayList<>();
    }

    public static ShoppingCartSingleton getInstance(){
        if(mShoppingCartSingleton == null)
            mShoppingCartSingleton = new ShoppingCartSingleton();
        return mShoppingCartSingleton;
    }

    public void addShoppingCart(ShoppingCart shoppingCartList){
        mShoppingCartList.add(shoppingCartList);
    }

    public List<ShoppingCart> getmShoppingCartList(){
        return mShoppingCartList;
    }
}
