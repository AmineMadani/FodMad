package com.fodmad.newsapp.models;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.fodmad.newsapp.NewsByCategory;
import com.fodmad.newsapp.R;

import java.util.ArrayList;

public class AdapterList extends BaseAdapter {

    Context context;
    ArrayList<ListCategory> listCategories;
    String[] categories ={ "science", "technology", "health", "business", "sports", "entertainment"};


    public AdapterList(Context context, ArrayList<ListCategory> listCategories) {
        this.context = context;
        this.listCategories = listCategories;
    }

    @Override
    public int getCount() {
        return listCategories.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }


    @Override
    public View getView(final int position, View view, ViewGroup parent) {

        view = LayoutInflater.from(context).inflate(R.layout.category_list,parent,false);

        TextView title = view.findViewById(R.id.title);
        TextView description = view.findViewById(R.id.description);
        ImageView image = view.findViewById(R.id.image);


        title.setText(listCategories.get(position).getTitle());
        description.setText(listCategories.get(position).getDescription());
        image.setImageResource(listCategories.get(position).getImages());

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "All actualities about "+ categories[position], Toast.LENGTH_SHORT).show();

                int pos = position;

                Intent intent = new Intent(context, NewsByCategory.class);

                Bundle extras = new Bundle();
                extras.putInt("POSITION", position);

                //attach the bundle to the Intent object
                intent.putExtras(extras);

                context.startActivity(intent);


            }
        });

        return view;
    }

}
