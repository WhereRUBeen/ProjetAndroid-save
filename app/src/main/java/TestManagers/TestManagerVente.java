package TestManagers;

import com.example.arsene.mamieclafoutisandroid.Vente;

import java.util.ArrayList;

import entities.Ventes;

/**
 * Created by mayammouarangue on 28/11/17.
 */

public class TestManagerVente {

    public static ArrayList<Ventes> listeVentes;

    public static void insert(Ventes vente){
        listeVentes.add(new Ventes(vente.getDate_horaire(),vente.getUtilisateur_id(),vente.getQuantite(),vente.getProduit_id(),
                vente.getId()));
    }

    public static ArrayList<Ventes> getAll(){
        if (listeVentes!=null){
            return listeVentes;
        }
        else
            return null;
    }
}
