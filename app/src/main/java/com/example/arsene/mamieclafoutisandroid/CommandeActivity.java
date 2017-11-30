package com.example.arsene.mamieclafoutisandroid;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import com.example.arsene.mamieclafoutisandroid.adapters.CommandeAdapter;
import entities.Produit;

public class CommandeActivity extends AppCompatActivity {

    Context ctx;
    ListView commandeListView;
    CommandeAdapter adapter;
    Button passerCommande;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_commande);
        ctx = this;
        passerCommande = (Button) findViewById(R.id.bttnPasserCommande);
        commandeListView = (ListView) findViewById(R.id.commandeListeView);

        // initialisation commande adapter
        //adapter = new CommandeAdapter(ctx,R.layout.commande_view,)


        // listener sur la list view
        commandeListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Produit produit =(Produit) adapterView.getItemAtPosition(i);


            }
        });




        // listener bttn passer commande
        passerCommande.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
}
