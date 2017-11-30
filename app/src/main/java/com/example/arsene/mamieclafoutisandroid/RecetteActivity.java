package com.example.arsene.mamieclafoutisandroid;


import java.util.ArrayList;


import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.arsene.mamieclafoutisandroid.adapters.IngredientAdapter;
import entities.Produit;

public class RecetteActivity extends Activity {

    Button btnmodifier;


    ArrayList<Produit> ingredientarray = new ArrayList<Produit>();

    IngredientAdapter rows;



    static ArrayList<String> result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recette);

        btnmodifier = (Button) findViewById(R.id.recettem);



        btnmodifier.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

    }
}
