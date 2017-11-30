package managers;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

import entities.Categorie;
import services.C;
import services.ConnexionBd;

/**
 * Created by mayammouarangue on 28/11/17.
 */

public class ManagerCategorie {

    public static void insert(Context ctx, Categorie categorie){
        ContentValues cv = new ContentValues();
        cv.put(C.Categorie.denomination,categorie.getDenomination());
        SQLiteDatabase bd = ConnexionBd.getBd(ctx);
        bd.insert(C.Categorie.nomTable,null,cv);
    }

    public static ArrayList<Categorie> getAll(Context ctx){
        ArrayList<Categorie> retour = new ArrayList<>();
        String query = "select * from "+C.Categorie.nomTable+";";

        SQLiteDatabase bd = ConnexionBd.getBd(ctx);
        Cursor c = bd.rawQuery(query,null);

        while(c.moveToNext()){

            int id = c.getInt(0);
            String denomination = c.getString(1);

            Categorie categorie = new Categorie(id,denomination);
            retour.add(categorie);
        }


        return retour;
    }
}
























