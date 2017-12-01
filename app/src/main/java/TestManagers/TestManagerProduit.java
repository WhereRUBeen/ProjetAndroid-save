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


    public static void insert(ArrayList<Produit> prods){

         lesProduits = new ArrayList<>();

         if (lesProduits != null){
             for(Produit p : prods){
                 lesProduits.add(p);
             }
         }


        System.out.println("taille proooooood:"+ lesProduits);
        Log.d("taille testMan",lesProduits.size()+"");  // ça marche
        Log.d("taille testMan",lesProduits.get(1).getNom()+""); // ça marche
    }


    public static ArrayList<Produit> getAll(){

        ArrayList<Produit> prod = new ArrayList<>();

        if (prod == null) {
            for (Produit p : lesProduits) {
                prod.add(p);
            }
        }

        return prod;
    }


    public static ArrayList<Produit> getArray(Produit [] tab){

        ArrayList<Produit> retour = new ArrayList<>();
        Produit []test= new Produit[tab.length];

        for (int i=0; i<tab.length; i++){
            for (int j=0; j< tab.length; j++){
                test[j]= tab[i];
            }
            retour.add(test[i]);
        }
        return retour;
    }
}
