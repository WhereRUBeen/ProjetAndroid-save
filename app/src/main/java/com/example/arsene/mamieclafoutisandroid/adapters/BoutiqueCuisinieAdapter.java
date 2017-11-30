package com.example.arsene.mamieclafoutisandroid.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.arsene.mamieclafoutisandroid.R;

import java.util.List;

import entities.Produit;

/**
 * Created by mayammouarangue on 27/11/17.
 */

public class BoutiqueCuisinieAdapter extends ArrayAdapter<Produit> {
    Context ctx;
    int layoutId;

    public BoutiqueCuisinieAdapter(Context context, int resource,List<Produit> objects) {
        super(context, resource, objects);
        ctx = context;
        layoutId = resource;
    }

    @Override
    public View getView(int position,View convertView, ViewGroup parent) {

        if (convertView == null){
            LayoutInflater inflater = LayoutInflater.from(ctx);
            convertView = inflater.inflate(layoutId,null);
        }

        // les composant du layout
        ImageView imgProduit = convertView.findViewById(R.id.imgProdBoutiqueCuisinie);
        TextView nomProduit = convertView.findViewById(R.id.txtNomProdBoutiqueCuisinie);
        TextView prixProduit = convertView.findViewById(R.id.txtPrixBoutiqueCuisinie);

        return convertView;
    }
}
