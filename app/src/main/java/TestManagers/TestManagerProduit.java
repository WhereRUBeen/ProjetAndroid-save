package TestManagers;

import android.util.Log;

import java.util.ArrayList;

import entities.Produit;

/**
 * Created by mayammouarangue on 28/11/17.
 */

public class TestManagerProduit {

    private static ArrayList<Produit> lesProduits;


    public static void insert(ArrayList<Produit> prods){
        lesProduits = new ArrayList<>();
        for(Produit p : prods){
            lesProduits.add(p);
        }
        System.out.println("taille :"+ lesProduits);
        Log.d("taille testMan",lesProduits.size()+"");
        Log.d("taille testMan",lesProduits.get(1).getNom()+"");
    }

    
    public static ArrayList<Produit> getAll(){
            return lesProduits;
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
