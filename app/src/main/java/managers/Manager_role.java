package managers;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

import entities.Role;
import services.C;
import services.ConnexionBd;

/**
 * Created by Been WhereU on 2017-11-28.
 */

public class Manager_role {

    public static void insertRole(Context ctx, Role role){
        ContentValues cv = new ContentValues();
        cv.put(C.Role.titre,role.getTitre());
        SQLiteDatabase bd = ConnexionBd.getBd(ctx);
        bd.insert(C.Categorie.nomTable,null,cv);
    }

    public static ArrayList<Role> getRole(Context ctx){
        ArrayList<Role> retour = new ArrayList();
        String query = "select * from "+C.Role.nomTable+";";
        SQLiteDatabase base = ConnexionBd.getBd(ctx);
        Cursor c = base.rawQuery(query,null);
        while (c.moveToNext()){
            int id = c.getInt(0);
            String titre = c.getString(1);
            Role r = new Role(id,titre);
            retour.add(r);
        }
        return retour;
    }


    private static  ArrayList<Role> lesRoles;

    private static void init(){
        lesRoles = new ArrayList<>();

        lesRoles.add(new Role(1,"Admin"));
        lesRoles.add(new Role(2,"Chef Boulanger"));
        lesRoles.add(new Role(3,"Gérant"));
        lesRoles.add(new Role(4,"Cuisinier"));
        lesRoles.add(new Role(5,"Vendeur"));
        lesRoles.add(new Role(6,"Professionnel"));

    }


    public static ArrayList<Role> getAll(){
        if (lesRoles == null){
            init();
        }
       return lesRoles;
    }

}
