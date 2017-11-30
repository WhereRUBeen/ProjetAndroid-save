package com.example.arsene.mamieclafoutisandroid.adapters;

import android.content.Context;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.arsene.mamieclafoutisandroid.R;

import entities.Ingredient;

/**
 * Created by bigg- on 11/27/2017.
 */

public class IngredientAdapter extends ArrayAdapter<Ingredient> {

    Context ctx;
    int layoutid;

    public IngredientAdapter(Context context, int resource) {
        super(context, resource);
        ctx= context;
        layoutid=resource;

    }

    @Override
    public View getView(int position,View convertView,ViewGroup parent) {

        Ingredient ingredient = getItem(position);


        if (convertView == null){
            LayoutInflater inflater = LayoutInflater.from(ctx);
            convertView = inflater.inflate(layoutid,null);
        }

        TextView ingredienttv = convertView.findViewById(R.id.ingredienttv);
        TextView quantitetv = convertView.findViewById(R.id.quantitetv);
        TextView descriptiontv = convertView.findViewById(R.id.descriptiontv);



        return convertView;
    }

}




















