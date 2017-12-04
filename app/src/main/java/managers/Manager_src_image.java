package managers;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.Set;

import entities.ImageList;
import services.C;
import services.ConnexionBd;

/**
 * Created by Been WhereU on 2017-12-01.
 */

public class Manager_src_image {

    private static String queryByIdProductImg="select * from src_image where produit_id=? ";

    public static void insertImg(Context ctx , ImageList src_image){

        ContentValues cv = new ContentValues();

        cv.put(C.Src_image.id, src_image.getId());
        cv.put(C.Src_image.src_img_mobile, src_image.getSrc_img_mobile());
        cv.put(C.Src_image.produit_id, src_image.getProduit_id());

        SQLiteDatabase bd = ConnexionBd.getBd(ctx);
        bd.insert(C.Src_image.nomTable,null,cv);

        bd.close();
    }

    public static ArrayList<ImageList> getAllImage(Context ctx){
        ArrayList<ImageList> retour = new ArrayList<>();

        SQLiteDatabase bd = ConnexionBd.getBd(ctx);
        String query = "select * from "+C.Src_image.nomTable+";";

        Cursor c = bd.rawQuery(query,null);

        while (c.moveToNext()){
            int id = c.getInt(0);
            String src_image_taille_mobile = c.getString(1);
            int produit_id = c.getInt(2);

            ImageList src = new ImageList(id,src_image_taille_mobile,produit_id);
            retour.add(src);
    }
    return retour;
}}
