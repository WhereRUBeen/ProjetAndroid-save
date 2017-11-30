package com.example.arsene.mamieclafoutisandroid.utils;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.google.gson.Gson;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
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

import entities.Commande;
import services.C;

/**
 * Created by mayammouarangue on 26/11/17.
 */

public class CommandesToServer extends AsyncTask<String,Long,String> {
    Context ctx;
    Commande laCommande;
    public CommandesToServer(Context ctx, Commande laCommande) {
        this.ctx = ctx;
        this.laCommande = laCommande;
    }

    @Override
    protected String doInBackground(String... strings) {
        String retour="";

        HttpURLConnection connection = null;
        StringBuilder sb = new StringBuilder();
        String requestURL = C.adresseIp;  // A COMPLETER
        OutputStream out;

        URL url = null;

        try {
            Gson gson = new Gson(); // pour envoyer la commande
            String commandeToSend = gson.toJson(laCommande);
            url = new URL(requestURL);
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setReadTimeout(15000);
            connection.setConnectTimeout(15000);
            connection.setDoInput(true);
            connection.setDoOutput(true);
            connection.setRequestProperty("Connection","Keep-Alive");
            connection.setRequestProperty("Content-Type", "application/json;charset=UTF-8");
            out = new BufferedOutputStream(connection.getOutputStream());
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(out,"UTF-8"));
            writer.write(commandeToSend);
            writer.flush();
            writer.close();

            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK){

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
            Log.d("test",retour);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        return retour;
    }
}































