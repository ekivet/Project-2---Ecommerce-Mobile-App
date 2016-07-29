package com.example.erickivet.motorcycleparts;

/**
 * Created by erickivet on 7/27/16.
 */
public class Products {
    private long id;
    private String mItemName;
    private int mItemImage;
    private String mItemDescription;
    private double mItemPrice;

    public Products (){
        mItemName = "default";
        mItemImage = 0;
        mItemDescription = "default";
        mItemPrice = 0.00;
    }

    public Products (String itemName, int itemImage, String itemDescription, double itemPrice){
        mItemName = itemName;
        mItemImage = itemImage;
        mItemDescription = itemDescription;
        mItemPrice = itemPrice;
    }

    public Products (long id,String itemName, int itemImage, String itemDescription, double itemPrice){
        this.id = id;
        mItemName = itemName;
        mItemImage = itemImage;
        mItemDescription = itemDescription;
        mItemPrice = itemPrice;
    }


    public String getItemName() {
        return mItemName;
    }

    public void setItemName(String itemName) {
        mItemName = itemName;
    }

    public int getItemImage() {
        return mItemImage;
    }

    public void setItemImage(int itemImage) {
        mItemImage = itemImage;
    }

    public String getItemDescription() {
        return mItemDescription;
    }

    public void setItemDescription (String itemDescription) {
        mItemDescription = itemDescription;
    }

    public double getItemPrice() {
        return mItemPrice;
    }

    public void setItemPrice (double itemPrice) {
        mItemPrice = itemPrice;
    }


}
