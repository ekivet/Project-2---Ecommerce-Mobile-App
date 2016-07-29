package com.example.erickivet.motorcycleparts;

import android.app.SearchManager;
import android.content.ComponentName;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.View;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.widget.ListView;
import android.view.Menu;
import android.view.MenuInflater;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView mRecyclerView;
    ShoppingHelper shoppingHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addData();

        shoppingHelper = shoppingHelper.getInstance(this);
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerview_main_activity);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this,
                LinearLayoutManager.VERTICAL,false));




        List <Products> productsList = shoppingHelper.getProductList();

        /**
            productsList.add(new Products("Yoshimura Exhaust",R.drawable.yoshimura_r77,"Loud Exhaust",400));
            productsList.add(new Products("AGV Pista",R.drawable.agv_pista,"Good Helmet",1399));
            productsList.add(new Products("Akrapovic Slip On Exhaust",R.drawable.akrapovic_slip_on,"Loud AF Exhaust",800));
            productsList.add(new Products("Alpine Stars Jacket",R.drawable.alpinestars_jacket,"Nice Jacket",300));
            productsList.add(new Products("K&N Air Filter",R.drawable.kn_air_filter,"Some Air Filter",49));
            productsList.add(new Products("Michelin Pilot Tires",R.drawable.michelin_pilot,"Some Tires",189));
            productsList.add(new Products("Tank Pads",R.drawable.stompgrip_tank_pad,"Tank Pads",100));
            productsList.add(new Products("Shoei GT Air",R.drawable.shoei_gt_air,"Shoei GT Air Helmet",500));
         */



        mRecyclerView.setAdapter(new MainRecyclerViewAdapter(productsList));


        /**
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();

            }
        });
         */

        //SearchManager searchManager = (SearchManager)getSystemService(Context.SEARCH_SERVICE);
        //SearchView searchView = (SearchView) menu.findItem(R.id.search).getActionView();


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.options_menu, menu);

        SearchManager searchManager = (SearchManager)getSystemService(Context.SEARCH_SERVICE);
        SearchView searchView = (SearchView) menu.findItem(R.id.search).getActionView();

        ComponentName componentName = new ComponentName(this,SearchResultActivity.class);
        searchView.setSearchableInfo(searchManager.getSearchableInfo(componentName));

        return true;
    }

    private void addData() {
        ShoppingHelper helper = ShoppingHelper.getInstance(MainActivity.this);
        Products product1 = new Products("Yoshimura Exhaust",R.drawable.yoshimura_r77,"Loud Exhaust",400);
        Products product2 = new Products("AGV Pista",R.drawable.agv_pista,"Good Helmet",1399);
        Products product3 = new Products("Akrapovic Slip On Exhaust",R.drawable.akrapovic_slip_on,"Loud AF Exhaust",800);
        Products product4 = new Products("Alpine Stars Jacket",R.drawable.alpinestars_jacket,"Nice Jacket",300);
        Products product5 = new Products("K&N Air Filter",R.drawable.kn_air_filter,"Some Air Filter",49);
        Products product6 = new Products("Michelin Pilot Tires",R.drawable.michelin_pilot,"Some Tires",189);
        Products product7 = new Products("Tank Pads",R.drawable.stompgrip_tank_pad,"Tank Pads",100);
        Products product8 = new Products("Shoei GT Air",R.drawable.shoei_gt_air,"Shoei GT Air Helmet",500);

        helper.insertRow(product1);
        helper.insertRow(product2);
        helper.insertRow(product3);
        helper.insertRow(product4);
        helper.insertRow(product5);
        helper.insertRow(product6);
        helper.insertRow(product7);
        helper.insertRow(product8);

    }
}
