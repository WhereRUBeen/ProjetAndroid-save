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
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


import com.example.arsene.mamieclafoutisandroid.adapters.BoutiqueCuisinieAdapter;

import java.util.ArrayList;

import TestManagers.TestManagerProduit;
import entities.Categorie;
import entities.Produit;
import managers.ManagerCategorie;
import managers.ManagerProduitPanier;
import managers.Manager_Produit;

public class BoutiqueCuisinie extends Activity {
    Context ctx;
    ArrayList<Produit> lesProduits;
    ArrayList<Produit> testproduits;
    ArrayList<Categorie> lesCategories;
    ArrayList<Produit> selectionProduit;
    ListView boutiqueLv;
    BoutiqueCuisinieAdapter adapter;
    Button bttnPanier;
    String r;
    // les composants du layout
    TextView nom;
    TextView categorie;
    TextView prix;
    TextView poids;
    TextView unite;
    TextView description;
    TextView recette;

    // button ajout et soustraction quantite
    Button ajoutQuantite;
    Button enleveQuantite;
    TextView affichageQuantite;

    Produit produitCourrant;


    // button ajouter au panier
    Button ajouterAuPanier;

    //spinner boutique
    Spinner spinner;
    ArrayAdapter<String> spinnerAdapter ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_boutique_cuisinie);
        ctx = this;
        // composants layout
        // listView
        boutiqueLv = (ListView) findViewById(R.id.boutiqueCuisinieListView);
        bttnPanier = (Button) findViewById(R.id.bttnCuisinieCommande);

        //get le spinner
        spinner = (Spinner) findViewById(R.id.spinnerBoutiqueCategorieCuisinie);

        // les Arraylists contenant les produits
        lesProduits = new ArrayList<>();
        //lesProduits = Manager_Produit.getAll(ctx);
        lesProduits = Manager_Produit.getAll(ctx);
        Log.d("produit base",lesProduits.size()+"");
        testproduits = new ArrayList<>();   // contient tous les produits de toute catégories
        // testproduits = Manager_Produit.getAll(ctx);
        testproduits = TestManagerProduit.getAll();


        // action bar color
        // get le role + condition pour des couleurs differente pour chaque role

        ActionBar bar = getActionBar();
        bar.setBackgroundDrawable(new ColorDrawable(Color.rgb(255,204,204)));


        // init selectionProduit
        selectionProduit = new ArrayList<Produit>();
        selectionProduit.addAll(lesProduits);

        lesCategories = new ArrayList<>();
        lesCategories = ManagerCategorie.getAll(ctx);
        Log.d("categories base", lesCategories.size()+"");


        // adpater spinner
        spinnerAdapter = new ArrayAdapter<String>(ctx,android.R.layout.simple_spinner_dropdown_item);

        for (Categorie c : lesCategories) {
            if (c.getId() == 1 ){
                spinnerAdapter.add(c.getDenomination());

            }

            if (c.getId() == 2){
                spinnerAdapter.add(c.getDenomination());
            }

            if (c.getId() == 5){
                spinnerAdapter.add(c.getDenomination());
            }
            if (c.getId() == 8){
                spinnerAdapter.add(c.getDenomination());

            }
            if (c.getId() == 9){
                spinnerAdapter.add(c.getDenomination());
            }

        }

        // set adapter spinner
        spinner.setAdapter(spinnerAdapter);
        //listen sur le spinner
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                selectionProduit = new ArrayList<Produit>();
                selectionProduit.addAll(lesProduits);
                String selected = adapterView.getItemAtPosition(i).toString();
               // Toast.makeText(ctx, selected, Toast.LENGTH_SHORT).show();


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

                adapter = new BoutiqueCuisinieAdapter(ctx, R.layout.boutique_cuisinie_view, selectionProduit);
                // set listView adapter
                boutiqueLv.setAdapter(adapter);

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        // listen sur la listView
        boutiqueLv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                produitCourrant = (Produit) adapterView.getItemAtPosition(i);
               // Toast.makeText(ctx, produitCourrant.getNom(), Toast.LENGTH_SHORT).show();

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


                nom = (TextView) dialog.findViewById(R.id.actProd_nom);
                categorie = (TextView) dialog.findViewById(R.id.actProd_categorie);
                prix = (TextView) dialog.findViewById(R.id.actProd_prix);
                poids = (TextView) dialog.findViewById(R.id.actProd_poix);
                unite = (TextView) dialog.findViewById(R.id.actProd_unite);
                description = (TextView) dialog.findViewById(R.id.actProd_desc);
                recette = (TextView) dialog.findViewById(R.id.actProd_recette);

                // button ajout et soustraction quantite
                ajoutQuantite = (Button) dialog.findViewById(R.id.ajoutQuantite);
                enleveQuantite = (Button) dialog.findViewById(R.id.enleveQuantite);
                affichageQuantite = (TextView) dialog.findViewById(R.id.afficheQuantite);

                // button ajouter au panier
                ajouterAuPanier = (Button) dialog.findViewById(R.id.ajoutPanierDialog);


                // set les composants
                nom.setText(produitCourrant.getNom());
                categorie.setText(produitCourrant.getCategorie().getDenomination());
                prix.setText(produitCourrant.getPrix()+" $");
                poids.setText(produitCourrant.getPoid()+"");
                description.setText(produitCourrant.getDescription());


                //ajout quantite produit
                ajoutQuantite.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        //Toast.makeText(ctx, "+", Toast.LENGTH_LONG).show();

                        produitCourrant.setQuantite(produitCourrant.getQuantite()+1);
                        affichageQuantite.setText(""+ produitCourrant.getQuantite());
                    }
                });

                // soustraction quantite produit
                enleveQuantite.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        //Toast.makeText(ctx, "-", Toast.LENGTH_LONG).show();

                        if (produitCourrant.getQuantite() > 0){
                            produitCourrant.setQuantite(produitCourrant.getQuantite()-1);
                        }
                        // retrait quantite
                        affichageQuantite.setText(""+produitCourrant.getQuantite());

                    }
                });

                // ajout au panier
                ajouterAuPanier.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        Produit produit = new Produit(produitCourrant.getId(),produitCourrant.getQuantite());

                        // on passe le produit courant au panier
                        ManagerProduitPanier.init(produitCourrant);

                    }
                });

            }
        });


        // redirection vers CommandeActivity (Panier)
        bttnPanier.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent();
                intent.setClass(ctx,CommandeActivity.class);
                startActivity(intent);
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
}
