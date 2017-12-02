package com.example.arsene.mamieclafoutisandroid;

import android.app.Activity;
import android.content.Context;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.example.arsene.mamieclafoutisandroid.adapters.CommandeAdapter;
import com.example.arsene.mamieclafoutisandroid.utils.CommandesToServer;
import com.example.arsene.mamieclafoutisandroid.utils.SharedPreferenceCommande;
import com.example.arsene.mamieclafoutisandroid.utils.SharedePreferenceUser;

import java.util.ArrayList;

import entities.Commande;
import entities.Produit;
import managers.ManagerProduitPanier;

public class CommandeActivity extends Activity {

    Context ctx;
    ListView commandeListView;
    CommandeAdapter adapter;
    Button passerCommande;
    ArrayList<Produit> lesProduits;
    ArrayList<Commande> lesCommandes;
    Produit produit;
    Button retirer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_commande);
        ctx = this;
        passerCommande = (Button) findViewById(R.id.bttnPasserCommande);
        commandeListView = (ListView) findViewById(R.id.commandeListeView);

        lesCommandes = new ArrayList<>();
        lesProduits = new ArrayList<>();

        lesProduits = ManagerProduitPanier.getAll();
        // initialisation commande adapter
        adapter = new CommandeAdapter(ctx,R.layout.commande_view,lesProduits);
        commandeListView.setAdapter(adapter);


        // listener sur la list view
        commandeListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(final AdapterView<?> adapterView, View view, final int i, long l) {

                produit =(Produit) adapterView.getItemAtPosition(i);


                // get button retirer Button
                retirer = (Button) view.findViewById(R.id.retirerCommande);




                // retire le produit du panier
                retirer.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        adapter.remove(produit);
                        Toast.makeText(ctx, "Your Message", Toast.LENGTH_LONG).show();

                    }
                });



                // cree alertdialog builder
                AlertDialog.Builder builder = new AlertDialog.Builder(ctx);
                LayoutInflater inflater = LayoutInflater.from(ctx);
                builder.setTitle("Détails Produit");
                builder.setView(inflater.inflate(R.layout.details_produit,null));

                // cree alertdialog
                AlertDialog dialog = builder.create();
                dialog.show();

            }

        });


        // listener bttn passer commande
        passerCommande.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                new SharedPreferenceCommande(ctx,lesProduits);
                new CommandesToServer(ctx);
            }
        });
    }
}
