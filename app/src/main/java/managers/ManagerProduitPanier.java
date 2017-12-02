package managers;

import java.util.ArrayList;

import entities.Produit;

/**
 * Created by mayammouarangue on 02/12/17.
 */

public class ManagerProduitPanier {

    private static ArrayList<Produit> lesProduits = new ArrayList<>();


    public static void init(Produit produit){

        lesProduits.add(produit);
    }



    public static ArrayList<Produit> getAll(){
        return lesProduits;
    }
}
