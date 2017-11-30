package services;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Been WhereU on 2017-11-27.
 */

public class GestionBase extends SQLiteOpenHelper {

    public GestionBase(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    private static final String queryDropEtablissement = "DROP TABLE IF EXISTS" + C.Etablissement.nomTable + ";";
    private static final String queryDropAdresse = "DROP TABLE IF EXISTS" + C.Adresse.nomTable + ";";
    private static final String queryDroptype = "DROP TABLE IF EXISTS" + C.Type.nomTable + ";";
    private static final String queryDropRole = "DROP TABLE IF EXISTS" + C.Role.nomTable + ";";
    private static final String queryDropRoleEtablissement = "DROP TABLE IF EXISTS" + C.Role_etablissement.nomTable + ";";
    private static final String queryDropUtilisateur = "DROP TABLE IF EXISTS" + C.Utilisateur.nomTable + ";";
    private static final String queryDropProduit = "DROP TABLE IF EXISTS" + C.Produit.nomTable + ";";
    private static final String queryDropIngredient = "DROP TABLE IF EXISTS" + C.Ingredient.nomTable + ";";
    private static final String queryDropCategorie = "DROP TABLE IF EXISTS" + C.Categorie.nomTable + ";";
    private static final String queryDropSrcImage = "DROP TABLE IF EXISTS" + C.Src_image.nomTable + ";";
    private static final String queryDropLigneIngredient = "DROP TABLE IF EXISTS" + C.Ligne_ingredient.nomTable + ";";
    private static final String queryDropProduitPatte = "DROP TABLE IF EXISTS" + C.Produit_patte.nomTable + ";";
    private static final String queryDropUnite = "DROP TABLE IF EXISTS" + C.Unite.nomTable + ";";
    private static final String queryDropIngredientPatte = "DROP TABLE IF EXISTS" + C.Ingredient_patte.nomTable + ";";
    private static final String queryDropPatte = "DROP TABLE IF EXISTS" + C.Patte.nomTable + ";";
    private static final String queryDropProduction = "DROP TABLE IF EXISTS" + C.Production.nomTable + ";";
    private static final String queryDropCommande = "DROP TABLE IF EXISTS" + C.Commande.nomTable + ";";
    private static final String queryDropCommeandeInterne = "DROP TABLE IF EXISTS" + C.Commande_interne.nomTable + ";";
    private static final String queryDropVente = "DROP TABLE IF EXISTS" + C.Ventes.nomTable + ";";
    private static final String queryDropProduitPropose = "DROP TABLE IF EXISTS" + C.Produit_propose.nomTable + ";";


    private static final String queryCreateEtablissement = "CREATE TABLE " + C.Etablissement.nomTable + " (" +
            C.Etablissement.id + " INTEGER PRIMARY KEY AUTOINCREMENT , " +
            C.Etablissement.name + " TEXT , " +
            C.Etablissement.tel + " TEXT , " +
            C.Etablissement.type_id + " INTEGER , " +
            C.Etablissement.adresse_id + " INTEGER , " +
            C.Etablissement.isVisible + " INTEGER);";


    private static final String queryCreateAdresse = "CREATE TABLE " + C.Adresse.nomTable + " (" +
            C.Adresse.id + " INTEGER PRIMARY KEY AUTOINCREMENT , " +
            C.Adresse.numero_rue + " TEXT , " +
            C.Adresse.nom_rue + " TEXT , " +
            C.Adresse.ville + " TEXT , " +
            C.Adresse.province + " TEXT , " +
            C.Adresse.code_postale + " TEXT , " +
            C.Adresse.pays + " TEXT);";

    private static final String queryCreateType = "CREATE TABLE " + C.Type.nomTable + " (" +
            C.Type.id + " INTEGER PRIMARY KEY AUTOINCREMENT , " +
            C.Type.denomination + " TEXT);";


    private static final String queryCreateRole = "CREATE TABLE " + C.Role.nomTable + " (" +
            C.Role.id + " INTEGER PRIMARY KEY AUTOINCREMENT , " +
            C.Role.titre + " TEXT);";


    private static final String queryCreateRoleEtablissement = "CREATE TABLE " + C.Role_etablissement.nomTable + " (" +
            C.Role_etablissement.type_id + " INTEGER PRIMARY KEY AUTOINCREMENT , " +
            C.Role_etablissement.role_id + " TEXT);";

    @Override
    public void onCreate(SQLiteDatabase bd) {
        bd.execSQL(queryCreateEtablissement);
        bd.execSQL(queryCreateAdresse);
        bd.execSQL(queryCreateType);
       // bd.execSQL(queryCreateRole);
        bd.execSQL(queryCreateRoleEtablissement);
    }

    @Override
    public void onUpgrade(SQLiteDatabase bd, int i, int i1) {

    }
}

