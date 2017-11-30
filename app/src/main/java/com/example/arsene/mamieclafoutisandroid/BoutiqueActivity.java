package com.example.arsene.mamieclafoutisandroid;

import android.app.Activity;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

import TestManagers.TestManagerProduit;
import entities.Produit;

public class BoutiqueActivity extends Activity {
    Context ctx;
    TextView taille;
    ArrayList<Produit> produits;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_boutique);
        ctx = this;

        produits = new ArrayList<>();

      //  produits = TestManagerProduit.getAll();
      //  System.out.println("taille array "+ produits.size()+"  ");
      //  System.out.println("nom prod "+produits.get(1).getNom());
      //  taille = (TextView) findViewById(R.id.testMan);
        //taille.setText(produits.size()+"");


    }
}
