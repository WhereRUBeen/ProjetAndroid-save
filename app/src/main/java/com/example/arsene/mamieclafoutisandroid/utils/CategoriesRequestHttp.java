package com.example.arsene.mamieclafoutisandroid.utils;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

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

import entities.Categorie;
import entities.Parametre;
import entities.ParametresProduit;
import managers.ManagerCategorie;
import services.C;

/**
 * Created by mayammouarangue on 26/11/17.
 */

public class CategoriesRequestHttp extends AsyncTask<String, Long,String>{
    Context ctx;
    public CategoriesRequestHttp(Context ctx) {
        this.ctx = ctx;
    }

    @Override
    protected String doInBackground(String... strings) {
        String retour ="";
        HttpURLConnection connection = null;
        StringBuilder sb = new StringBuilder();

        String requestURL = C.urlGetCategorieHugo; // A COMPLETER
        Gson gson = new Gson();

        ParametresProduit p = new ParametresProduit();
        Parametre param = new Parametre();

        p.setUrl("getallcategories");
        p.setToken(strings[0]);
        String requete = gson.toJson(p);

        URL url = null;

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
            writer.write(requete); // A COMPLETER
            writer.flush();
            writer.close();

            int responseCode = connection.getResponseCode();
            Log.d("test","response code : "+responseCode);
            if (responseCode == HttpURLConnection.HTTP_OK){
                String line;
                BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                while ((line = br.readLine()) != null){
                    retour +=line + "\n";
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
        Log.d("Get","onPostExecute : "+ s);

        if (!s.equals("")){
            Gson gson = new Gson();
            if (!s.equals("-1")){

                Categorie[] lesCatégories = gson.fromJson(s,Categorie[].class);

                Log.d("categorie",lesCatégories.length+"");
                TypeToken<ArrayList<Categorie>> token = new TypeToken<ArrayList<Categorie>>(){};
                ArrayList<Categorie> testCategories = new ArrayList<>();
                testCategories = gson.fromJson(s,token.getType());

                for ( Categorie c : testCategories){

                    ManagerCategorie.insert(ctx,c);
                    Log.d("nos produit", c.toString());
                    Log.d("nos produit", c.getDenomination());


                }
                Log.d("nos produit",  ManagerCategorie.getAll(ctx).size() + "");

            }
        }
    }
}


















































