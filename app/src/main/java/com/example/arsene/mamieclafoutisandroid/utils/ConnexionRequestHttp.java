package com.example.arsene.mamieclafoutisandroid.utils;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import com.example.arsene.mamieclafoutisandroid.BoutiqueActivity;
import com.example.arsene.mamieclafoutisandroid.ConnexionActivity;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;


import entities.Utilisateur;
import services.C;

/**
 * Created by mayammouarangue on 25/11/17.
 */

public class ConnexionRequestHttp extends AsyncTask<String, Long, String>{
    Context ctx;
    ConnexionActivity connexionActivity;
    Utilisateur utilisateur;

    public ConnexionRequestHttp(Context ctx, ConnexionActivity connexionActivity) {
        this.ctx = ctx;
        this.connexionActivity = connexionActivity;
    }

    @Override
    protected String doInBackground(String... strings) {
        String retour = "";
        HttpURLConnection connection = null;
        StringBuilder sb = new StringBuilder();

        String requestUrl = C.adresseIp+strings[0];
        Log.d("test",requestUrl);
        if (strings[2] != null){

            utilisateur = new Utilisateur(strings[1],strings[2]);
        }else {
            utilisateur = new Utilisateur(strings[1]);
        }

        // le url
        URL url = null;

        try {

            Gson gson = new Gson();
            String s = gson.toJson(utilisateur);
            Log.d("test","json à envoyé "+s);

            url = new URL(requestUrl);
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
            writer.write(s);
            writer.flush();
            writer.close();

            int responseCode = connection.getResponseCode();
            Log.d("test","responseCode : "+responseCode);

            if (responseCode == HttpURLConnection.HTTP_OK){
                String line;
                BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));

                while ( (line = br.readLine())!=null){
                    retour += line+"\n";
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
        Log.d("test","on post execute connection : "+ s);

        Gson gson = new Gson();

        if (!s.equals("")){

            if (!s.equals("-1")){

                Utilisateur utilisateur = gson.fromJson(s,Utilisateur.class);
                Log.d("test","login user "+utilisateur.getUserName());


                Intent intent = new Intent();
                intent.setClass(ctx, BoutiqueActivity.class);
                ctx.startActivity(intent);
                connexionActivity.finish();
            }
            else {
                Toast.makeText(ctx, "Identifiant ou Mot de passe incorect.", Toast.LENGTH_LONG).show();
            }
        }
        else {
            Toast.makeText(ctx, "Erreur de connéxion à la base de donnée.", Toast.LENGTH_LONG).show();
        }

    }
}





























