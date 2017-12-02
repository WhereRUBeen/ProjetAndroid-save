package TestManagers;

import android.content.Context;
import android.util.Log;

import java.util.ArrayList;

import entities.Produit;
import managers.Manager_Produit;

/**
 * Created by mayammouarangue on 28/11/17.
 */

public class TestManagerProduit {

    private static ArrayList<Produit> lesProduits;

/*
    public static void insert(ArrayList<Produit> prods){

         lesProduits = new ArrayList<>();

         if (lesProduits != null){
             for(Produit p : prods){
                 lesProduits.add(p);
             }
         }


        System.out.println("taille proooooood:"+ lesProduits);
        Log.d("taille testMan",lesProduits.size()+"");  // ça marche
        Log.d("taille testMan",lesProduits.get(4).getNom()+""); // ça marche
    }

*/
    public static void init(){

        lesProduits = new ArrayList<>();
        lesProduits.add(new Produit(1,"pain",Float.parseFloat("39.9922")));
        lesProduits.add(new Produit(1,"baguette",Float.parseFloat("39.9922")));
        lesProduits.add(new Produit(1,"croissant",Float.parseFloat("39.9922")));
    }
    public static ArrayList<Produit> getAll(){


        if (lesProduits == null)
            init();

        return lesProduits;
    }



}
