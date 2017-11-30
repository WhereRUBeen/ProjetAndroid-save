package com.example.arsene.mamieclafoutisandroid.utils;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.example.arsene.mamieclafoutisandroid.ConnexionActivity;

import java.net.HttpURLConnection;

import entities.Produit;
import services.C;

/**
 * Created by Been WhereU on 2017-11-28.
 */

public class ProduitRequestHttp extends AsyncTask<String,Long,String> {

    Context ctx;
    ConnexionActivity connexionActivity;
    Produit produit;

    public ProduitRequestHttp(Context ctx, ConnexionActivity connexionActivity) {
        this.ctx = ctx;
        this.connexionActivity = connexionActivity;
    }

    @Override
    protected String doInBackground(String... strings) {
        String retour ="";
        HttpURLConnection connexion = null;
        StringBuilder stbuilder = new StringBuilder();

        String requestURL = C.adresseIp+strings[0];
        Log.d("Produit",requestURL);



        return null;
    }
}
