package services;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by Been WhereU on 2017-11-27.
 */

public class ConnexionBd {

    private static SQLiteDatabase bd;
    private static int versionBD = 1;


    public static SQLiteDatabase getBd(Context ctx){
        GestionBase gbase = new GestionBase(ctx, C.nombd, null, versionBD);
        bd = gbase.getWritableDatabase();
        return  bd;
    }

    public static void close(){
        bd.close();
    }
}
