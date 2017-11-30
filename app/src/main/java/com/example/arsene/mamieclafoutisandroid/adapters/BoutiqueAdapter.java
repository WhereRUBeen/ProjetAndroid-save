package com.example.arsene.mamieclafoutisandroid.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.arsene.mamieclafoutisandroid.R;

import java.util.List;

import entities.Produit;

/**
 * Created by mayammouarangue on 25/11/17.
 */

public class BoutiqueAdapter extends ArrayAdapter<Produit> {
    //attributs
    Context ctx;
    int layoutId;

    public BoutiqueAdapter(Context context, int resource, List<Produit> objects) {
        super(context, resource, objects);
        ctx = context;
        layoutId =resource;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null){
            LayoutInflater inflater =LayoutInflater.from(ctx);
            convertView = inflater.inflate(layoutId, null);
        }

        // les composants du layout
        // image produit, nom et prix unitaire
        ImageView imageProduit = convertView.findViewById(R.id.boutiqueProduitImgView);
        TextView textViewNomProduit = convertView.findViewById(R.id.boutiqueProduitNomTxtView);
        TextView textViewPrixProduit = convertView.findViewById(R.id.textViewBoutiquePrixProd);

        // buttons ajout/soustraction et text view quantite
        Button bttnAjoutQuantite = convertView.findViewById(R.id.bttnBoutiqueAjoutQuantiteProd);
        Button bttnSoustraitQuantite = convertView.findViewById(R.id.bttnBoutiqueSoustraitQuantiteProd);
        TextView textViewQuantite = convertView.findViewById(R.id.textViewBoutiqueQuantiteProd);

        // text view prix total
        TextView textViewPrixTotal = convertView.findViewById(R.id.textViewBoutiquePrixTotal);

        // button ajouter
        Button bttnAjouter = convertView.findViewById(R.id.bttnBoutiqueAjouterProd);







        return convertView;
    }
}
