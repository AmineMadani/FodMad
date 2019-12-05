package com.fodmad.newsapp.models;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ListView;

import com.fodmad.newsapp.FavoriteActivity;
import com.fodmad.newsapp.LoginActivity;
import com.fodmad.newsapp.MainActivity;
import com.fodmad.newsapp.R;

import java.util.ArrayList;

public class CategoryActivity extends AppCompatActivity {

    ListView listView;
    ArrayList<ListCategory> list;
    Context context;
    AdapterList adapterList = new AdapterList (context, list);

    private ActionBar toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_category);

        listView = (ListView) findViewById(R.id.list_view);

        listShow();

        adapterList = new AdapterList(this,list);
        listView.setAdapter(adapterList);


        toolbar = getSupportActionBar();
        toolbar.setTitle("Categories");

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.NavBot);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        navigation.getMenu().findItem(R.id.category).setChecked(true);

    }


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {



        @Override
        public boolean onNavigationItemSelected( MenuItem item) {

            switch (item.getItemId()) {
                case R.id.category:
                    break;

                case R.id.home:
                    Intent intent2 = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(intent2);
                    break;

                case R.id.profile:
                    Intent intent3 = new Intent(getApplicationContext(), LoginActivity.class);
                    startActivity(intent3);
                    break;

                case R.id.favorite:
                    Intent intent4 = new Intent(getApplicationContext(), FavoriteActivity.class);
                    startActivity(intent4);
                    break;

            }

            return false;
        }
    };


    public ArrayList listShow(){
        list = new ArrayList <ListCategory>();
        list.add(new ListCategory("Science","All actualities about science", R.drawable.science,"science"));
        list.add(new ListCategory("Technology","All actualities about technology",R.drawable.technology, "technoloy"));
        list.add(new ListCategory("Health","All actualities about health ",R.drawable.health, "health"));
        list.add(new ListCategory("Business","All actualities about business ",R.drawable.business, "business"));
        list.add(new ListCategory("Sport","All actualities about sport",R.drawable.sports, "sports"));
        list.add(new ListCategory("Entertainment","All actualities about entertainment",R.drawable.entertainment , "entertainment"));

        return list;
    }




}
