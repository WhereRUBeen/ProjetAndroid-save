package com.example.arsene.mamieclafoutisandroid;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.arsene.mamieclafoutisandroid.adapters.BoutiqueCorporateAdapter;

import java.util.ArrayList;

import TestManagers.TestManagerProduit;
import entities.Categorie;
import entities.Produit;
import managers.ManagerCategorie;

public class BoutiqueCorporate extends Activity {
    Context ctx;
    // les composants du layout
    TextView nom;
    TextView categorie;
    TextView prix;
    TextView poids;
    TextView unite;
    TextView description;
    TextView recette;

    //spinner boutique
    Spinner spinner;
    ArrayAdapter<String> spinnerAdapter;

    // BoutiqueCorporateAdapter
    BoutiqueCorporateAdapter adapter;

    // les Arraylists
    ArrayList<Categorie> lesCategories;
    ArrayList<Produit> lesProduits;

    ListView boutiqueLv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_boutique_corporate);
        ctx = this;
        boutiqueLv = (ListView) findViewById(R.id.boutiqueCorpListView); // getListView

        lesProduits = new ArrayList<>();
        lesProduits = TestManagerProduit.getAll();
        System.out.println("boutique corp prod "+ lesProduits.size());
        // init les categories
        lesCategories = new ArrayList<>();
        lesCategories = ManagerCategorie.getAll(ctx);

        spinner = (Spinner) findViewById(R.id.spinnerBoutiqueCategorieCorp);


        // get les categories
        spinnerAdapter = new ArrayAdapter<String>(ctx,android.R.layout.simple_spinner_dropdown_item);
        for (Categorie c : lesCategories) {
            spinnerAdapter.add(c.getDenomination());
        }

        //set l'adapter du spinner
        spinner.setAdapter(spinnerAdapter);

        // get adapter listView
        adapter = new BoutiqueCorporateAdapter(ctx,R.layout.boutique_corporate_view,lesProduits);
        System.out.println("boutique corp prod "+ lesProduits.size());
        //set adapter listView
        boutiqueLv.setAdapter(adapter);


    }
}
