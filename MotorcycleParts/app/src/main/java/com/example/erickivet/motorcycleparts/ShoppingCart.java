package com.example.erickivet.motorcycleparts;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by erickivet on 7/27/16.
 */

public class ShoppingCart {

    ArrayList<Products>cartList;

    private static ShoppingCart thisInstance = new ShoppingCart();

    public static ShoppingCart getInstance(){
        if (thisInstance == null){
            thisInstance = new ShoppingCart();
        }
        return thisInstance;
    }

    private ShoppingCart(){
        this.cartList = new ArrayList<>();
    }

    public ArrayList<Products> getCartList() {
        return cartList;
    }


    public void addProduct(Products item){
        cartList.add(item);
    }


    public void removeItem(Products item){
        cartList.remove(item);
    }


    public void clearCart(){
        cartList.clear();
    }
}
