package TestManagers;

import java.util.ArrayList;

import entities.Commande;

/**
 * Created by mayammouarangue on 28/11/17.
 */

public class TestManagerCommande {

    private static ArrayList<Commande> listeCommande;

    public static void insert(Commande commande){
        listeCommande.add(new Commande(commande.getId(),commande.getUtilisateur_id(),commande.getDate(),commande.getValide()));
    }

    public static ArrayList<Commande> getAll(){
        if (listeCommande != null){
            return listeCommande;
        }
        else
            return null;
    }

}
