package com.example.erickivet.motorcycleparts;

import android.app.SearchManager;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.support.v4.widget.CursorAdapter;
import android.support.v4.widget.SimpleCursorAdapter;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

public class SearchResultActivity extends AppCompatActivity {

    /*
    * Conduct search query using name data as an input value
    * Display results in a listview
    * */

    private CursorAdapter mCursorAdapter;
    private ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_result);


        mListView = (ListView) findViewById(R.id.search_listview);
        mListView.setEmptyView(findViewById(R.id.no_results));

        Intent intent = getIntent();

        if(Intent.ACTION_SEARCH.equals(intent.getAction())){
            String query = intent.getStringExtra(SearchManager.QUERY);
            Cursor cursor = ShoppingHelper.getInstance(this).searchItems(query);

            mCursorAdapter = new SimpleCursorAdapter
                    (this, android.R.layout.simple_list_item_1,cursor,
                            new String[]{ShoppingHelper.COL_ITEM_NAME},
                            new int[]{android.R.id.text1},0);

            mListView.setAdapter(mCursorAdapter);
        }

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, final View view, int position, long id) {


                AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
                builder.setTitle("Add Item");
                builder.setMessage("Add Item to Shopping Cart?");
                builder.setPositiveButton("ADD",new DialogInterface.OnClickListener(){
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(view.getContext(),"Item Added",Toast.LENGTH_SHORT).show();
                    }
                });
                builder.setNegativeButton("CANCEL",new DialogInterface.OnClickListener(){
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });

    }
}
