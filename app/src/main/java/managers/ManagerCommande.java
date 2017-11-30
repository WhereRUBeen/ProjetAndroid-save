package managers;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

import entities.Commande;
import services.C;
import services.ConnexionBd;

/**
 * Created by mayammouarangue on 28/11/17.
 */

public class ManagerCommande {

    public static void insert(Context ctx, Commande commande){
        ContentValues cv = new ContentValues();

        cv.put(C.Commande.id,commande.getId());
        cv.put(C.Commande.utilisateur_id, commande.getUtilisateur_id());
        cv.put(C.Commande.date, commande.getDate());
        cv.put(C.Commande.valide,commande.getValide());

        SQLiteDatabase bd = ConnexionBd.getBd(ctx);
        bd.insert(C.Commande.nomTable,null,cv);
    }

    public static ArrayList<Commande> getAll(Context ctx){
        ArrayList<Commande> retour = new ArrayList<>();
        String query = "select * from "+C.Commande.nomTable+";";

        SQLiteDatabase bd = ConnexionBd.getBd(ctx);
        Cursor c = bd.rawQuery(query,null);

        while(c.moveToNext()){
            int id = c.getInt(0);
            int utilisatteur_id = c.getInt(1);
            Long date = c.getLong(2);
            int valide = c.getInt(3);

            Commande commande = new Commande(id, utilisatteur_id, date, valide);
            retour.add(commande);
        }

        return  retour;
    }
}
