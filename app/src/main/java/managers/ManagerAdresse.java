package managers;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

import entities.Adresse;
import services.C;
import services.ConnexionBd;

/**
 * Created by mayammouarangue on 27/11/17.
 */

public class ManagerAdresse {

    private static void insert(Context ctx, Adresse adresse){

        ContentValues cv = new ContentValues();
        cv.put(C.Adresse.numero_rue,adresse.getNumero_rue());
        cv.put(C.Adresse.nom_rue,adresse.getNom_rue());
        cv.put(C.Adresse.ville,adresse.getVille());
        cv.put(C.Adresse.province,adresse.getProvince());
        cv.put(C.Adresse.code_postale,adresse.getCode_postal());
        cv.put(C.Adresse.pays,adresse.getPays());

    }

    private static ArrayList<Adresse> getAll(Context ctx){
        ArrayList<Adresse> retour = new ArrayList<>();
        String query="select * from "+C.Adresse.nomTable+";";

        SQLiteDatabase bd = ConnexionBd.getBd(ctx);
        Cursor c = bd.rawQuery(query,null);

        while (c.moveToNext()){
            int numero_rue = c.getInt(0);
            String nom_rue = c.getString(1);
            String ville = c.getString(2);
            String province = c.getString(3);
            String code_postal = c.getString(4);
            String pays = c.getString(5);

            Adresse a = new Adresse(-1,numero_rue,nom_rue,ville,province,code_postal,pays);
            retour.add(a);
        }

        return retour;
    }

}
