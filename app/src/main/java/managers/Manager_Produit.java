package managers;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

import entities.Produit;
import services.C;
import services.ConnexionBd;
import com.example.arsene.mamieclafoutisandroid.utils.Mydb;

/**
 * Created by Been WhereU on 2017-11-26.
 */

public class Manager_Produit {
    private static final String queryGetAll = "Select * from " + Mydb.Produit.tablename + ";";

    public static void insert(Context ctx, Produit produit) {
        ContentValues cv = new ContentValues();
        cv.put(C.Produit.id, produit.getId());
        cv.put(C.Produit.nom, produit.getNom());
        cv.put(C.Produit.categorie_id, produit.getCategorie_id());
        cv.put(C.Produit.description, produit.getDescription());
        cv.put(C.Produit.prix, produit.getPrix());
        cv.put(C.Produit.poid, produit.getPoid());
        cv.put(C.Produit.reference, produit.getReference());//
        cv.put(C.Produit.unite_id, produit.getUnite_id());



        SQLiteDatabase bd = ConnexionBd.getBd(ctx);
        bd.insert(C.Produit.nomTable, null, cv);

        bd.close();
    }




    public static ArrayList<Produit> getAll(Context ctx) {
        ArrayList<Produit> retour = new ArrayList<>();

        SQLiteDatabase bd = ConnexionBd.getBd(ctx);
        Cursor c = bd.rawQuery(queryGetAll, null);

        while (c.moveToNext()) {
            int id = c.getInt(0);
            String nom = c.getString(1);
            int categorie_id = c.getInt(2);
            String description = c.getString(3);
            float prix = c.getFloat(4);

            float poid = c.getFloat(5);
            String reference = c.getString(6);
            int unite_id = c.getInt(7);

            //String unite = c.getString(7);
            Produit s = new Produit(id, nom, categorie_id, description, prix,reference, poid,  unite_id);
            retour.add(s);
        }
        return retour;

    }
}

