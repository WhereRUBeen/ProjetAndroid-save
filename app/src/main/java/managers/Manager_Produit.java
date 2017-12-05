package managers;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.arsene.mamieclafoutisandroid.utils.Mydb;

import java.util.ArrayList;

import entities.Categorie;
import entities.ImageList;
import entities.Produit;
import services.C;
import services.ConnexionBd;

/**
 * Created by Been WhereU on 2017-11-26.
 */

public class Manager_Produit {
    private static final String queryGetAll = "Select * from " + Mydb.Produit.tablename + ";";

    public static void insert(Context ctx, Produit produit) {
        ContentValues cv = new ContentValues();

        cv.put(C.Produit.id, produit.getId());
        cv.put(C.Produit.nom, produit.getNom());
        cv.put(C.Categorie.id_categorie, produit.getCategorie().getId());
        cv.put(C.Categorie.denomination, produit.getCategorie().getDenomination());
        cv.put(C.Produit.description, produit.getDescription());
        cv.put(C.Produit.prix, produit.getPrix());
        cv.put(C.Produit.poid, produit.getPoid());
        cv.put(C.Unite.uniteDenomination,produit.getUnite().getDenomination());
        for (ImageList img: produit.getImageList()) {

            Log.d("image",img.getSrc_img_mobile());

            cv.put(C.Src_image.produit_id,img.getProduit_id());
            cv.put(C.Src_image.src_img_mobile,img.getSrc_img_mobile());

             Manager_src_image.insertImg(ctx,img);

        }
        Log.d("produitBase2",Manager_src_image.getAllImage(ctx).size()+"");

        // cv.put(C.ImageList.produit_id,produit.getSrcImage().getProduit_id());
      //  cv.put(C.Src_image.src_img_mobile,produit.getimageList().getImageList());
        cv.put(C.Produit.quantite,produit.getQuantite());


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
            int id_categorie= c.getInt(2);
            String denomination = c.getString(3);
            String description = c.getString(4);
            float prix = c.getFloat(5);
            float poid = c.getFloat(6);
            String uniteDenomination = c.getString(7);
            int quantite = c.getInt(10);
          //  int unite_id = c.getInt(7);

            //String unite = c.getString(7);
          // Produit s = new Produit(id, nom,  prix);
           Produit produit = new Produit(id,nom,new Categorie(id_categorie,denomination),description,prix,poid,quantite);
           retour.add(produit);
        }
        return retour;

    }
}

