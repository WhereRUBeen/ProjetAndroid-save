package managers;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

import entities.Ventes;
import services.C;
import services.ConnexionBd;

/**
 * Created by mayammouarangue on 28/11/17.
 */

public class ManagerVente {

    public static void insert(Context ctx, Ventes vente){
        ContentValues cv = new ContentValues();

        cv.put(C.Ventes.date_horaire,vente.getDate_horaire());
        cv.put(C.Ventes.utilisateur_id,vente.getUtilisateur_id());
        cv.put(C.Ventes.quantite,vente.getQuantite());
        cv.put(C.Ventes.produit_id,vente.getProduit_id());
        cv.put(C.Ventes.id,vente.getId());

        SQLiteDatabase bd = ConnexionBd.getBd(ctx);
        bd.insert(C.Ventes.nomTable,null,cv);
    }

    public static ArrayList<Ventes> getAll(Context ctx){
        ArrayList<Ventes> retour = new ArrayList<>();
        String query = "select * from "+C.Ventes.nomTable+";";

        SQLiteDatabase bd = ConnexionBd.getBd(ctx);
        Cursor c = bd.rawQuery(query,null);

        while (c.moveToNext()){
            Long date_horraire = c.getLong(0);
            int utilisateur_id = c.getInt(1);
            int quantite = c.getInt(2);
            int produit_id = c.getInt(3);
            int id = c.getInt(4);

            Ventes v = new Ventes(date_horraire,utilisateur_id,quantite,produit_id,id);
            retour.add(v);
        }

        return retour;
    }
}
