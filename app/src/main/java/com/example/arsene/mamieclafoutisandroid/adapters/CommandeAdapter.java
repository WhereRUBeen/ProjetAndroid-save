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

public class CommandeAdapter extends ArrayAdapter<Produit> {
    //attributs
    Context ctx;
    int layoutId;
    //constructeur
    public CommandeAdapter(Context context, int resource,List<Produit> objects) {
        super(context, resource, objects);

        this.ctx = context;
        this.layoutId = resource;
    }

    @Override
    public View getView(int position,View convertView,ViewGroup parent) {
        // le produit
        Produit produit = getItem(position);


        if (convertView == null){
            LayoutInflater inflater = LayoutInflater.from(ctx);
            convertView = inflater.inflate(layoutId,null);
        }

        // les composants du layout
        // image produit, nom et prix unitaire
        ImageView imageProduit = convertView.findViewById(R.id.cmdProduitImgView);
        TextView textViewNomProduit = convertView.findViewById(R.id.cmdProduitNomTxtView);
        TextView textViewPrixProduit = convertView.findViewById(R.id.cmdProduitPrixTxtView);

        // buttons ajout/soustraction et text view quantite
        Button bttnAjoutQuantite = convertView.findViewById(R.id.cmdQuantiteAjout);
        Button bttnSoustraitQuantite = convertView.findViewById(R.id.cmdQuantiteSupp);
        TextView textViewQuantite = convertView.findViewById(R.id.cmdQuantiteTxtView);

        // text view prix total commande
        TextView textViewPrixTotal = convertView.findViewById(R.id.cmdPrixTotalTextView);

        // button retirer commande
        Button bttnRetirerCommande = convertView.findViewById(R.id.retirerCommande);


        return convertView;
    }


}
