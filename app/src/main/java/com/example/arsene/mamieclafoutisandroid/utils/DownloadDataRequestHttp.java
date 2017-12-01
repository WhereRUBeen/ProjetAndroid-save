package com.example.arsene.mamieclafoutisandroid.utils;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import TestManagers.TestManagerProduit;
import entities.Parametre;
import entities.ParametresProduit;
import entities.Produit;
import managers.Manager_Produit;
import services.C;

/**
 * Created by mayammouarangue on 26/11/17.
 */

public class DownloadDataRequestHttp extends AsyncTask<String,Long,String>{
    Context ctx;
    public DownloadDataRequestHttp(Context ctx) {
        this.ctx = ctx;
    }

    @Override
    protected String doInBackground(String... strings) {
        String retour ="";
        HttpURLConnection connection = null;
        StringBuilder sb = new StringBuilder();

        String requestURL = C.urlGetProduits; // A COMPLETER

        URL url = null;
        Gson gson = new Gson();

        ParametresProduit p = new ParametresProduit();
        Parametre param = new Parametre();

        // par Id
       // param.setIdParam("categorieId");
     //  param.setValeurParam("3");

       // toutes
        p.setUrl("displayproduit");

        // par ID
        p.setToken(new SharedePreferenceUser(ctx).getUserSharedPreference().getTokenIdentification());
       // p.setUrl("displayproduitCategorie");
       // p.setParametreList(param);

        String requete = gson.toJson(p);

        try {
            url = new URL(requestURL);
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setReadTimeout(15000);
            connection.setConnectTimeout(15000);
            connection.setDoInput(true);
            connection.setDoOutput(true);
            OutputStream os = connection.getOutputStream();
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(os,"UTF-8"));
            Log.d("test",requete);
            writer.write(requete);
            writer.flush();
            writer.close();

            int responseCode = connection.getResponseCode();
            Log.d("test","response code : "+ responseCode);
            if (responseCode == HttpURLConnection.HTTP_OK){
                String line;
                BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                while ((line = br.readLine()) != null) {
                    retour += line + "\n";
                }

            }
            os.close();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            connection.disconnect();
        }
        return retour;
    }

    @Override
    protected void onPostExecute(String s) {
        Log.d("test","onPostExecute "+ s);




        if (!s.equals("")){
          Gson gson = new Gson();

            if (!s.equals("-1")){

               //List<Produit> lesProduits;
                 //lesProduits = gson.fromJson(s,Produit.class);

                Produit[] lesProds =gson.fromJson(s,Produit[].class);
                Log.d("prod", lesProds.length+"");
                ArrayList<Produit> testproduit = new ArrayList<Produit>();

                TypeToken<ArrayList<Produit>> token = new TypeToken<ArrayList<Produit>>(){};
                testproduit = gson.fromJson(s,token.getType());



                // System.out.println("taille testProduit"+ testproduit.size());
                Log.d("taille", testproduit.size()+"");

                TestManagerProduit.insert(testproduit);

            }

        }
    }
}







































