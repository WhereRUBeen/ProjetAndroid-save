package com.example.arsene.mamieclafoutisandroid;

import android.app.Activity;
import android.content.Context;

import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.arsene.mamieclafoutisandroid.adapters.BoutiqueAdapter;

import org.w3c.dom.Text;

import java.util.ArrayList;

 import entities.Produit;


public class BoutiqueActivity extends Activity {
    Context ctx;
    ArrayList<Produit> lesProduits;
    ListView boutiqueLv;
    BoutiqueAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_boutique);
        ctx = this;
        lesProduits = new ArrayList<>();
        boutiqueLv = (ListView) findViewById(R.id.boutiqueListView);
        adapter = new BoutiqueAdapter(ctx,R.layout.boutique_view,lesProduits);


        boutiqueLv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Produit p = (Produit) adapterView.getItemAtPosition(i);

                // cree alertdialog
                AlertDialog.Builder builder = new AlertDialog.Builder(ctx);
                LayoutInflater inflater = LayoutInflater.from(ctx);
                builder.setTitle("Ajouter au panier");
                builder.setView(inflater.inflate(R.layout.activity_produit,null));


                //alert dialog
                AlertDialog dialog = builder.create();
                dialog.show();

                // get les composants
                ImageView img1 = (ImageView) findViewById(R.id.image1);
                ImageView img2 = (ImageView) findViewById(R.id.image2);
                ImageView img3 = (ImageView) findViewById(R.id.image3);
                ImageView img4 = (ImageView) findViewById(R.id.image4);

                TextView nom = (TextView) findViewById(R.id.actProd_nom);
                TextView categorie = (TextView) findViewById(R.id.actProd_categorie);
                TextView prix = (TextView) findViewById(R.id.actProd_prix);
                TextView poids = (TextView) findViewById(R.id.actProd_poix);
                TextView unite = (TextView) findViewById(R.id.actProd_unite);
                TextView description = (TextView) findViewById(R.id.actProd_desc);
                TextView recette = (TextView) findViewById(R.id.actProd_recette);

                Button bttnAjoutQuantite = (Button) findViewById(R.id.ajoutQuantite);
                Button bttnEnleveQuantite = (Button) findViewById(R.id.enleveQuantite);
                Button ajoutPanier = (Button) findViewById(R.id.ajoutPanier);
                TextView afficheQuantite = (TextView) findViewById(R.id.afficheQuantite);
                // set les composants
                //les images
                //
                //
                //
                nom.setText(p.getNom());
                //categorie.setText();
                prix.setText(p.getPrix()+" $");
                poids.setText(p.getPoid()+"");
                //unite.setText();
                description.setText(p.getDescription());


                bttnAjoutQuantite.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                    }
                });

                bttnEnleveQuantite.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                    }
                });

                ajoutPanier.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {


                    }
                });
            }
        });



    }
}
