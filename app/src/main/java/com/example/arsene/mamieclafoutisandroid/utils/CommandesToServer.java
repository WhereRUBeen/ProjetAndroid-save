package com.example.arsene.mamieclafoutisandroid.utils;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.google.gson.Gson;

import java.io.BufferedInputStream;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import entities.Commande;
import entities.ParametresCommande;

import entities.Produit;

import services.C;

/**
 * Created by mayammouarangue on 26/11/17.
 */

public class CommandesToServer extends AsyncTask<String,Long,String> {

    Context ctx;
    ArrayList<Produit> lesProduits = new ArrayList<>();

    ArrayList<Commande> lesCommandes;

    public CommandesToServer(Context ctx, ArrayList<Produit> lesProds) {
        this.ctx = ctx;
       // this.lesProduits = lesProds;


        for (Produit p : lesProds ){
            lesProduits.add(p);
        }

        Log.d("cmd",lesProduits.size()+"");
    }

    public CommandesToServer(Context ctx) {
        this.ctx = ctx;
    }


    @Override
    protected String doInBackground(String... strings) {

        String retour="";

        Log.d("cmd","dedans");

        HttpURLConnection connection = null;
        StringBuilder sb = new StringBuilder();
        String requestURL = C.urlSendCommandeHugo;  // A COMPLETER
        Log.d("cmd",requestURL);

        ParametresCommande param = new ParametresCommande();
        param.setUrl("soumettrecommande");
        param.setProduitList(lesProduits);

        Log.d("cmd",param.getProduitList().size()+"");

        URL url = null;
        Gson gson = new Gson(); // pour envoyer la requete


        // Utilisateur utilisateur = SharedePreference.
        //String token = .getTokenIdentification();
        String token = new SharedePreferenceUser(ctx).getUserSharedPreference().getTokenIdentification();
        Log.d("cmd",token);
        param.setToken(token);


        String commandeToSend = gson.toJson(param);



        try {

            url = new URL(requestURL);
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setReadTimeout(15000);
            connection.setConnectTimeout(15000);
            connection.setDoInput(true);
            connection.setDoOutput(true);
            connection.setRequestProperty("Connection","Keep-Alive");
            connection.setRequestProperty("Content-Type", "application/json;charset=UTF-8");
            OutputStream os = connection.getOutputStream();
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(os,"UTF-8"));
            writer.write(commandeToSend);
            writer.flush();
            writer.close();

            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK){
                Log.d("cmd", responseCode+"");

                InputStream in = new BufferedInputStream(connection.getInputStream());
                BufferedReader reader = new BufferedReader(new InputStreamReader(in,"UTF-8"));
                sb = new StringBuilder();
                String line = null;
                while ((line = reader.readLine())!=null){
                    sb.append(line);
                }
                in.close();
            }
            retour = sb.toString();
            Log.d("cmd",retour);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        return retour;
    }

    @Override
    protected void onPostExecute(String s) {
        Log.d("cmd","onPostExecute "+ s);



    }
}































