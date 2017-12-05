package com.example.arsene.mamieclafoutisandroid;

import android.app.ActionBar;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.arsene.mamieclafoutisandroid.adapters.BoutiqueCorporateAdapter;

import java.util.ArrayList;

import TestManagers.TestManagerProduit;
import entities.Categorie;
import entities.Produit;
import managers.ManagerCategorie;
import managers.Manager_Produit;

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

    Produit produitCourrant;
    // les Arraylists
    ArrayList<Categorie> lesCategories;
    ArrayList<Produit> lesProduits;
    ArrayList<Produit> selectionProduit;

    ListView boutiqueLv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_boutique_corporate);
        ctx = this;
        boutiqueLv = (ListView) findViewById(R.id.boutiqueCorpListView); // getListView

        lesProduits = new ArrayList<>();
        lesProduits = Manager_Produit.getAll(ctx);
        Log.d("produit base",lesProduits.size()+"");
        System.out.println("boutique corp prod "+ lesProduits.size());
        // init les categories
        lesCategories = new ArrayList<>();
        lesCategories = ManagerCategorie.getAll(ctx);
        Log.d("categories base", lesCategories.size()+"");

        // init selectionProduit
        selectionProduit = new ArrayList<Produit>();
        selectionProduit.addAll(lesProduits);

        spinner = (Spinner) findViewById(R.id.spinnerBoutiqueCategorieCorp);



        // action bar color
        // get le role + condition pour des couleurs differente pour chaque role

        ActionBar bar = getActionBar();
        bar.setBackgroundDrawable(new ColorDrawable(Color.rgb(255,204,204)));


        // get les categories
        spinnerAdapter = new ArrayAdapter<String>(ctx,android.R.layout.simple_spinner_dropdown_item);
        for (Categorie c : lesCategories) {
            spinnerAdapter.add(c.getDenomination());
        }

        //set l'adapter du spinner
        spinner.setAdapter(spinnerAdapter);
        // listen sur le spinner
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                selectionProduit = new ArrayList<Produit>();
                selectionProduit.addAll(lesProduits);
                String selected = adapterView.getItemAtPosition(i).toString();
             //   Toast.makeText(ctx, selected, Toast.LENGTH_SHORT).show();

                System.out.println("taille initiale :"+ lesProduits.size());
                // List<Produit> toRemove = new ArrayList<>();
                ArrayList<Produit> toRemove = new ArrayList<>();

                for (Produit p : selectionProduit){

                    if (!selected.equals(p.getCategorie().getDenomination())){
                        toRemove.add(p);
                    }
                }
                System.out.println("taille toRemove :"+ toRemove.size());
                selectionProduit.removeAll(toRemove);
                System.out.println("nombre  produit : "+ selectionProduit.size());
                System.out.println("nom produit: "+ selectionProduit.get(0).getCategorie().getDenomination() );

                // get adapter listView
                adapter = new BoutiqueCorporateAdapter(ctx,R.layout.boutique_corporate_view,selectionProduit);
                System.out.println("boutique corp prod "+ lesProduits.size());
                //set adapter listView
                boutiqueLv.setAdapter(adapter);


            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        //listener sur la listView
        boutiqueLv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                produitCourrant = (Produit) adapterView.getItemAtPosition(i);


                AlertDialog.Builder builder = new AlertDialog.Builder(ctx);
                builder.setTitle("Détails produit");
                builder.setNegativeButton("Retour", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });

                LinearLayout linearLayout = (LinearLayout) getLayoutInflater().inflate(R.layout.details_produit,null);
                builder.setView(linearLayout);
                AlertDialog dialog = builder.create();
                dialog.getWindow().setLayout(800,800);
                dialog.show();


                // get les composants du layout
                nom = (TextView) dialog.findViewById(R.id.detailsProd_nom);
                categorie =(TextView) dialog.findViewById(R.id.detailsProd_categorie);
                prix =(TextView) dialog.findViewById(R.id.detailsProd_prix);
                poids = (TextView) dialog.findViewById(R.id.detailsProd_poix);
                unite =(TextView) dialog.findViewById(R.id.detailsProd_unite);
                description = (TextView) dialog.findViewById(R.id.detailsProd_desc);
                recette =(TextView) dialog.findViewById(R.id.detailsProd_recette);


                // set les composants
                nom.setText(produitCourrant.getNom());
                categorie.setText(produitCourrant.getCategorie().getDenomination());
                prix.setText(produitCourrant.getPrix()+" $");
                poids.setText(produitCourrant.getPoid()+"");
                description.setText(produitCourrant.getDescription());

            }
        });


    }
    //retour a l'activity de connexion whene press back
    @Override
    public void onBackPressed() {
        super.onBackPressed();

        Intent intent = new Intent();
        intent.setClass(ctx,ConnexionActivity.class);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_bar, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        String msg = "";

        switch (item.getItemId()){
            case R.id.chargement_base:
                msg = "Votre base de produit est a jour";
                break;

            case R.id.deconnection:
                msg = "Vous etes deconnecter";
                Intent intent = new Intent(ctx,ConnexionActivity.class);
                BoutiqueCorporate.this.finish();
                startActivity(intent);
        }
        Toast.makeText(getBaseContext(), msg, Toast.LENGTH_SHORT).show();
        return super.onOptionsItemSelected(item);
    }
}
