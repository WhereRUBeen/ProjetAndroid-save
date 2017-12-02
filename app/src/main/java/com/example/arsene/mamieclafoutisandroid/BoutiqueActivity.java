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

import android.widget.TextView;
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

                produitCourrant = (Produit) adapterView.getItemAtPosition(i);
                Toast.makeText(ctx, produitCourrant.getNom(), Toast.LENGTH_SHORT).show();

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

                //ajout quantite produit
                ajoutQuantite.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(ctx, "+", Toast.LENGTH_LONG).show();

                        // addition quantite
                        //affichageQuantite.setText();
                    }
                });

                // soustraction quantite produit
                enleveQuantite.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(ctx, "-", Toast.LENGTH_LONG).show();

                        // retrait quantite
                        //affichageQuantite.setText();

                    }
                });

                // ajout au panier
                ajouterAuPanier.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(ctx, "Your Message", Toast.LENGTH_LONG).show();

                       Produit produit = new Produit(produitCourrant.getId(),produitCourrant.getQuantite());




                    }
                });




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
