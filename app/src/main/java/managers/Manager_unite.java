package managers;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

import entities.Unite;
import services.C;
import services.ConnexionBd;

/**
 * Created by Been WhereU on 2017-11-28.
 */

public class Manager_unite {
    public static void insertUnite(Context ctx, Unite unite){
        ContentValues cv = new ContentValues();
        cv.put(C.Unite.denomination,unite.getDenomination());
        SQLiteDatabase bd = ConnexionBd.getBd(ctx);
        bd.insert(C.Categorie.nomTable,null,cv);
    }

    public static ArrayList<Unite> getAllUnite(Context ctx){
        ArrayList<Unite> retour = new ArrayList<>();
        String query = "select * from "+C.Unite.nomTable+";";

        SQLiteDatabase bd = ConnexionBd.getBd(ctx);
        Cursor c = bd.rawQuery(query,null);

        while(c.moveToNext()){

            int id = c.getInt(0);
            String denomination = c.getString(1);
            Unite unit = new Unite(id,denomination);
            retour.add(unit);
        }
        return retour;
    }

}
