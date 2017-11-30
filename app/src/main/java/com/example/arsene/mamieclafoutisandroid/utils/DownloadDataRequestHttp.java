package com.example.arsene.mamieclafoutisandroid.utils;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

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

        String requestURL = C.adresseIp; // A COMPLETER

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
            writer.write("");
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
        Log.d("get","onPostExecute "+ s);

        if (!s.equals("")){
            JSONArray jsonArray = null;  // pour recuperer les donnnées

            if (!s.equals("-1")){

                try {
                    jsonArray = new JSONArray(s);
                    // recuperer les arraylists d'objets seront leur index
                    //
                    //
                    //
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

        }
    }
}







































