package com.example.arsene.mamieclafoutisandroid;

import android.content.Context;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import com.example.arsene.mamieclafoutisandroid.adapters.CommandeAdapter;
import com.example.arsene.mamieclafoutisandroid.utils.CommandesToServer;
import com.example.arsene.mamieclafoutisandroid.utils.SharedePreferenceUser;

import java.util.ArrayList;

import entities.Commande;
import entities.Produit;

public class CommandeActivity extends AppCompatActivity {

    Context ctx;
    ListView commandeListView;
    CommandeAdapter adapter;
    Button passerCommande;
    ArrayList<Produit> lesProduits;
    ArrayList<Commande> lesCommandes;
    Produit produit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_commande);
        ctx = this;
        passerCommande = (Button) findViewById(R.id.bttnPasserCommande);
        commandeListView = (ListView) findViewById(R.id.commandeListeView);

        lesCommandes = new ArrayList<>();
        lesProduits = new ArrayList<>();
        // initialisation commande adapter
        adapter = new CommandeAdapter(ctx,R.layout.commande_view,lesProduits);


        // listener sur la list view
        commandeListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(final AdapterView<?> adapterView, View view, final int i, long l) {

                 produit =(Produit) adapterView.getItemAtPosition(i);


                // get button retirer Button
                Button retirer = (Button) findViewById(R.id.retirerCommande);
                // retire le produit du panier
                retirer.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        adapter.remove(produit);

                    }
                });


                // cree alertdialog
                AlertDialog.Builder builder = new AlertDialog.Builder(ctx);
                LayoutInflater inflater = LayoutInflater.from(ctx);

            }

        });


        // listener bttn passer commande
        passerCommande.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                SharedePreferenceUser preferenceUser = new SharedePreferenceUser(ctx);


                for (Produit p : lesProduits){

                    Commande laCommande = new Commande(-1,preferenceUser.getUserSharedPreference().getId(), produit.getId(),
                            produit.getQuantite());
                    lesCommandes.add(laCommande);


                   // new CommandesToServer(ctx,laCommande);

                }




            }
        });
    }
}
