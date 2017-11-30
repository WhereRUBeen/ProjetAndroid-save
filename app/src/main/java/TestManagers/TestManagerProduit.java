package TestManagers;

import java.util.ArrayList;

import entities.Produit;

/**
 * Created by mayammouarangue on 28/11/17.
 */

public class TestManagerProduit {

    private static ArrayList<Produit> lesProduits;

    public static void init(Produit produit){
        lesProduits = new ArrayList<>();
        lesProduits.add(new Produit(produit.getId(),produit.getNom(),produit.getPrix()));
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
