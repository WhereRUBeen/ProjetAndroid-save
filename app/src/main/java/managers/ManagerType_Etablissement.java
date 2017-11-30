package managers;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

import entities.Type_Etablissement;
import services.C;
import services.ConnexionBd;

/**
 * Created by mayammouarangue on 28/11/17.
 */

public class ManagerType_Etablissement {

    public static void insert(Context ctx, Type_Etablissement type){
        ContentValues cv = new ContentValues();
        cv.put(C.Type_Etablissement.id,type.getId());
        cv.put(C.Type_Etablissement.type,type.getType());

        SQLiteDatabase bd = ConnexionBd.getBd(ctx);
        bd.insert(C.Type_Etablissement.nomTable,null,cv);

    }

    public static ArrayList<Type_Etablissement> getAll(Context ctx){
        ArrayList<Type_Etablissement> retour = new ArrayList<>();
        String query = "select * from "+C.Type_Etablissement.nomTable+";";

        SQLiteDatabase bd = ConnexionBd.getBd(ctx);
        Cursor c = bd.rawQuery(query,null);

        while (c.moveToNext()){
            int id =c.getInt(0);
            String type = c.getString(1);

            Type_Etablissement t = new Type_Etablissement(id, type);
            retour.add(t);
        }

        return retour;
    }

}
