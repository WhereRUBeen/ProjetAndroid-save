package com.example.arsene.mamieclafoutisandroid;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import android.util.Log;

import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;

import android.widget.LinearLayout;
import android.widget.ListView;

import android.widget.Toast;

import com.example.arsene.mamieclafoutisandroid.adapters.BoutiqueAdapter;



import java.util.ArrayList;

import TestManagers.TestManagerProduit;
import entities.Produit;



public class BoutiqueActivity extends Activity {
    Context ctx;
    ArrayList<Produit> lesProduits;
    ArrayList<Produit> testproduits;
    ListView boutiqueLv;
    BoutiqueAdapter adapter;
    Button bttnPanier;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_boutique);
        ctx = this;
        bttnPanier = (Button) findViewById(R.id.bttnMaCommande);
        lesProduits = new ArrayList<>();
        boutiqueLv = (ListView) findViewById(R.id.boutiqueListView);
        testproduits = new ArrayList<>();
       // testproduits = Manager_Produit.getAll(ctx);
        testproduits = TestManagerProduit.getAll();
        adapter = new BoutiqueAdapter(ctx,R.layout.boutique_view,testproduits);

        Log.d("testproduit Taille",testproduits.size() +"");

        boutiqueLv.setAdapter(adapter);// on passe les produits dans notre adapatateur;
        boutiqueLv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Produit p = (Produit) adapterView.getItemAtPosition(i);
                Toast.makeText(ctx, p.getNom(), Toast.LENGTH_SHORT).show();

                AlertDialog.Builder builder = new AlertDialog.Builder(ctx);
                builder.setTitle("Ajouter au panier");
                builder.setNegativeButton("Retour", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });

                LinearLayout linearLayout = (LinearLayout) getLayoutInflater().inflate(R.layout.activity_produit,null);
                builder.setView(linearLayout);
                AlertDialog dialog = builder.create();
                dialog.getWindow().setLayout(800,800);
                dialog.show();


            }
        });


        // mets les produits dans le panier
        bttnPanier.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent();
                intent.setClass(ctx,CommandeActivity.class);
                startActivity(intent);
            }
        });


    }
}
