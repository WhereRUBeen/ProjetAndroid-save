package com.example.arsene.mamieclafoutisandroid.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import java.util.ArrayList;

import entities.Produit;

/**
 * Created by mayammouarangue on 02/12/17.
 */

public class SharedPreferenceCommande {
    Context ctx;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    ArrayList<Produit> lesProduits;

    public SharedPreferenceCommande(Context ctx) {
        this.ctx = ctx;
    }

    public SharedPreferenceCommande(Context ctx, ArrayList<Produit> lesProds) {
        this.ctx = ctx;
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this.ctx);
        editor = sharedPreferences.edit();


        for (Produit p : lesProds){
            lesProduits = new ArrayList<>();
            lesProduits.add(p);
        }
    }


    public void saveCommandeSharedPreference(){




    }



}
