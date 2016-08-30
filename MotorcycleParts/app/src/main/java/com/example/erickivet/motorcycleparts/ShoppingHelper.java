package com.example.erickivet.motorcycleparts;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by erickivet on 7/26/16.
 */
public class ShoppingHelper extends SQLiteOpenHelper{
    private static final String TAG = ShoppingHelper.class.getCanonicalName();

    private static final int DATABASE_VERSION = 5;
    public static final String DATABASE_NAME = "SHOPPING_DB";
    public static final String SHOPPING_LIST_TABLE_NAME = "CATALOG";
    public static final String SHOPPING_CART_TABLE_NAME = "SHOPPING_CART";

    public static final String COL_ID = "_id";
    public static final String COL_ITEM_NAME = "ITEM_NAME";
    public static final String COL_ITEM_IMAGE = "IMAGE";
    public static final String COL_ITEM_DESCRIPTION = "DESCRIPTION";
    public static final String COL_ITEM_PRICE = "PRICE";
    public static final String COL_ITEM_QUANTITY = "QUANTITY";


    public static final String [] SHOPPING_COLUMNS = {COL_ID,COL_ITEM_NAME,COL_ITEM_IMAGE,
            COL_ITEM_DESCRIPTION,COL_ITEM_PRICE};
    public static final String [] CART_COLUMNS = {COL_ID,COL_ITEM_NAME,COL_ITEM_QUANTITY,COL_ITEM_PRICE};

    public static final String CREATE_SHOPPING_LIST_TABLE =
            "CREATE TABLE " + SHOPPING_LIST_TABLE_NAME + "(" +
                    COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    COL_ITEM_NAME + " TEXT, " +
                    COL_ITEM_IMAGE + " TEXT, " +
                    COL_ITEM_DESCRIPTION + " TEXT, " +
                    COL_ITEM_PRICE + " TEXT )";

    public static final String CREATE_SHOPPING_CART_TABLE =
            "CREATE TABLE " + SHOPPING_CART_TABLE_NAME + "(" +
                    COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    COL_ITEM_NAME + " TEXT, " +
                    COL_ITEM_QUANTITY + " TEXT, " +
                    COL_ITEM_PRICE + " TEXT )";

    public ShoppingHelper(Context context){
        super(context, DATABASE_NAME,null,DATABASE_VERSION);
    }

    private static ShoppingHelper INSTANCE;

    public static synchronized ShoppingHelper getInstance(Context context) {
        if(INSTANCE == null)
            INSTANCE = new ShoppingHelper(context.getApplicationContext());
        return INSTANCE;
    }



    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        sqLiteDatabase.execSQL(CREATE_SHOPPING_LIST_TABLE);
        sqLiteDatabase.execSQL(CREATE_SHOPPING_CART_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + SHOPPING_CART_TABLE_NAME);
        this.onCreate(sqLiteDatabase);
    }

    public void insertRow(Products product) {
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COL_ITEM_NAME,product.getItemName());
        values.put(COL_ITEM_IMAGE,product.getItemImage());
        values.put(COL_ITEM_DESCRIPTION,product.getItemDescription());
        values.put(COL_ITEM_PRICE,product.getItemPrice());

        sqLiteDatabase.insertOrThrow(SHOPPING_LIST_TABLE_NAME,null,values);
    }

    public void insertRowCart(Products product) {
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COL_ITEM_NAME, product.getItemName());
        //values.put(COL_ITEM_QUANTITY,product.getItemQuantity);
        values.put(COL_ITEM_PRICE, product.getItemPrice());

        sqLiteDatabase.insertOrThrow(SHOPPING_CART_TABLE_NAME,null,values);
    }

    public List <Products> getProductList(){

        List <Products> listOfProducts = new ArrayList<>();

        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();

        Cursor cursor = sqLiteDatabase.query(SHOPPING_LIST_TABLE_NAME,
                SHOPPING_COLUMNS,
                null,
                null,
                null,
                null,
                null,
                null);

        if (cursor.moveToFirst()){
            while (!cursor.isAfterLast()){
                long id = cursor.getLong(cursor.getColumnIndex(COL_ID));
                String itemName = cursor.getString(cursor.getColumnIndex(COL_ITEM_NAME));
                int itemImage = cursor.getInt(cursor.getColumnIndex(COL_ITEM_IMAGE));
                String itemDescription = cursor.getString(cursor.getColumnIndex(COL_ITEM_DESCRIPTION));
                double itemPrice = cursor.getDouble(cursor.getColumnIndex(COL_ITEM_PRICE));

                Products products = new Products(id, itemName,itemImage,itemDescription,itemPrice);

                listOfProducts.add(products);
                cursor.moveToNext();
            }
        }

        return listOfProducts;


    }

    public Cursor searchItems (String query){

        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();

        Cursor cursor = sqLiteDatabase.query(SHOPPING_LIST_TABLE_NAME,
                SHOPPING_COLUMNS,
                COL_ITEM_NAME + " LIKE ?",
                new String[]{query + "%"},
                null,
                null,
                null,
                null);

        return cursor;

    }

}
