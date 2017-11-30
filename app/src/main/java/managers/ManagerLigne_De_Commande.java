package managers;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

import entities.Ligne_de_commande;
import services.C;
import services.ConnexionBd;

/**
 * Created by mayammouarangue on 28/11/17.
 */

public class ManagerLigne_De_Commande {

    private static void insert(Context ctx, Ligne_de_commande ligne_de_commande){
        ContentValues cv = new ContentValues();

        cv.put(C.Ligne_de_commande.commande_id, ligne_de_commande.getCommande_id());
        cv.put(C.Ligne_de_commande.produit_idproduit, ligne_de_commande.getProduit_idproduit());
        cv.put(C.Ligne_de_commande.quantite,ligne_de_commande.getQuantite());

        SQLiteDatabase bd = ConnexionBd.getBd(ctx);
        bd.insert(C.Ligne_de_commande.nomTable,null,cv);
    }

    public static ArrayList<Ligne_de_commande> getAll(Context ctx){
        ArrayList<Ligne_de_commande> retour = new ArrayList<>();
        String query = "select * from "+C.Ligne_de_commande.nomTable+";";

        SQLiteDatabase bd = ConnexionBd.getBd(ctx);
        Cursor c = bd.rawQuery(query,null);

        while (c.moveToNext()){
            int commande_id = c.getInt(0);
            int produit_idproduit = c.getInt(1);
            int quantite = c.getInt(2);

            Ligne_de_commande l = new Ligne_de_commande(commande_id,produit_idproduit,quantite);
            retour.add(l);
        }

        return retour;
    }
}
