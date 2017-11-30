package managers;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

import entities.Production;
import services.C;
import services.ConnexionBd;

/**
 * Created by mayammouarangue on 28/11/17.
 */

public class ManagerProduction {

    public static void insert(Context ctx, Production production){
        ContentValues cv = new ContentValues();
        cv.put(C.Production.utilisateur_id, production.getUtilisateur_id());
        cv.put(C.Production.produit_id, production.getProduit_id());
        cv.put(C.Production.quantite,production.getQuantite());
        cv.put(C.Production.date, production.getDate());

        SQLiteDatabase bd = ConnexionBd.getBd(ctx);
        bd.insert(C.Production.nomTable,null,cv);

    }

    public static ArrayList<Production> getAll(Context ctx){
        ArrayList<Production> retour = new ArrayList<>();
        String query = "select * from "+C.Production.nomTable+";";

        SQLiteDatabase bd = ConnexionBd.getBd(ctx);
        Cursor c = bd.rawQuery(query,null);

        while (c.moveToNext()){
            int utilisateur_id = c.getInt(0);
            int produit_id = c.getInt(1);
            int quantite = c.getInt(2);
            Long date = c.getLong(3);

            Production p = new Production(utilisateur_id,produit_id,quantite,date);
            retour.add(p);

        }

        return retour;
    }
}
