package managers;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import entities.Ingredient;
import services.C;
import services.ConnexionBd;

/**
 * Created by Been WhereU on 2017-11-28.
 */

public class Manager_ingredient {

    public static void insertIngredient(Context ctx, Ingredient ingredient){
        ContentValues cv = new ContentValues();
        cv.put(C.Ingredient.denomination,ingredient.getDenomination());
        cv.put(C.Ingredient.quantite,ingredient.getQuantite());
        cv.put(C.Ingredient.unite_id,ingredient.getUnite_ingredient());
        SQLiteDatabase bd = ConnexionBd.getBd(ctx);
        bd.insert(C.Categorie.nomTable,null,cv);
    }

    public static ArrayList<Ingredient> getAll(Context ctx){
        ArrayList<Ingredient> retour = new ArrayList<>();
        String query = "select * from "+C.Ingredient.nomTable+";";

        SQLiteDatabase bd = ConnexionBd.getBd(ctx);
        Cursor c = bd.rawQuery(query,null);

        while(c.moveToNext()){

            int id = c.getInt(0);
            String denomination = c.getString(1);
            int quantite = c.getInt(2);
            int unite_id = c.getInt(3);

            Ingredient categorie = new Ingredient(id,denomination,quantite,unite_id);
            retour.add(categorie);
        }
        return retour;
    }
}
