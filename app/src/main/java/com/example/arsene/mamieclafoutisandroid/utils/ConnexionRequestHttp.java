package com.example.arsene.mamieclafoutisandroid.utils;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import com.example.arsene.mamieclafoutisandroid.BoutiqueActivity;
import com.example.arsene.mamieclafoutisandroid.BoutiqueCorporate;
import com.example.arsene.mamieclafoutisandroid.BoutiqueCuisinie;
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
import java.util.ArrayList;


import entities.Etablissement;
import managers.ManagerEtablissement;
import entities.Role;
import entities.Type;
import entities.Utilisateur;
import managers.ManagerType;
import managers.Manager_role;
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

        String requestUrl = C.adresseIpHugo+strings[0];
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

                Log.d("token1", utilisateur.getTokenIdentification());
                // save l'utilisateur dans sharedPreference
                new SharedePreferenceUser(ctx,utilisateur).saveSharedPreference(); //mauvaise pratique
               // SharedePreferenceUser sharedePreferenceUser = new SharedePreferenceUser(ctx,utilisateur);
                SharedePreferenceUser.updateToken(ctx,utilisateur.getTokenIdentification());


                Log.d("token enregistre", new SharedePreferenceUser(ctx).getUserSharedPreference().getTokenIdentification());

                // Redirection fe l'utilisateur en fonction de son role et etablissement
                // les Arraylist
                ArrayList<Role> lesRoles = new ArrayList<>();
                lesRoles = Manager_role.getAll();

                ArrayList<Etablissement> lesEtabs =new ArrayList<>();
                lesEtabs = ManagerEtablissement.getAll();

                ArrayList<Type> lesTypes = new ArrayList<>();
                lesTypes = ManagerType.getAll();

                // get id etab du user
                int id_etab_user = utilisateur.getEtablissement().getTypeEtablissement().getId();
                Log.d("id etab user",id_etab_user+"");
                int id_etab = id_etab_user;

                int id_role_user = utilisateur.getRole().getId();
                Log.d("id role user",id_etab_user+"");

                int id_role = id_role_user;

                for(Etablissement e : lesEtabs){

                    if(id_etab_user == e.getType_id()){
                        id_etab = id_etab_user;
                    }
                }
                Log.d("id etab",id_etab+"");



                for (Role r : lesRoles){

                    if (id_role == r.getId()){
                        id_role = id_role_user;
                    }
                }

                Log.d("id role",id_role+"");




                Intent intent = new Intent();
                switch (id_etab){
                    case 1:
                        Log.d("id etab swith","true");

                        //admin
                        switch (id_role){
                            //admin
                            case 1:
                                Log.d("id role swith","true");

                                intent.setClass(ctx, BoutiqueCorporate.class);
                                ctx.startActivity(intent);
                                connexionActivity.finish();
                            break;
                            //chef boulanger
                            case 2:
                                intent.setClass(ctx, BoutiqueCorporate.class);
                                ctx.startActivity(intent);
                                connexionActivity.finish();
                            break;

                            case 3:
                                intent.setClass(ctx, BoutiqueCorporate.class);
                                ctx.startActivity(intent);
                                connexionActivity.finish();
                                break;
                            case 4:;
                                intent.setClass(ctx, BoutiqueCorporate.class);
                                ctx.startActivity(intent);
                                connexionActivity.finish();
                            break;
                            case 5:
                                intent.setClass(ctx, BoutiqueCorporate.class);
                                ctx.startActivity(intent);
                                connexionActivity.finish();
                            break;
                        }
                        break;
                    case 2:

                        //corporate
                        switch (id_role){
                            case 1:
                                Log.d("id role swith","true");

                                intent.setClass(ctx, BoutiqueCorporate.class);
                                ctx.startActivity(intent);
                                connexionActivity.finish();
                                break;
                            //chef boulanger
                            case 2:
                                intent.setClass(ctx, BoutiqueCorporate.class);
                                ctx.startActivity(intent);
                                connexionActivity.finish();
                                break;

                            case 3:
                                intent.setClass(ctx, BoutiqueCorporate.class);
                                ctx.startActivity(intent);
                                connexionActivity.finish();
                                break;
                            case 4:;
                                intent.setClass(ctx, BoutiqueCorporate.class);
                                ctx.startActivity(intent);
                                connexionActivity.finish();
                                break;
                            case 5:
                                intent.setClass(ctx, BoutiqueCorporate.class);
                                ctx.startActivity(intent);
                                connexionActivity.finish();
                                break;
                        }
                        break;

                    case 3:
                        //franchise
                        switch (id_role){

                            case 2:
                                intent.setClass(ctx, BoutiqueActivity.class);
                                ctx.startActivity(intent);
                                connexionActivity.finish();
                                break;
                            case 3:
                                intent.setClass(ctx, BoutiqueActivity.class);
                                ctx.startActivity(intent);
                                connexionActivity.finish();
                                break;
                            case 4:
                                intent.setClass(ctx, BoutiqueCuisinie.class);
                                ctx.startActivity(intent);
                                connexionActivity.finish();
                                break;
                            case 5:
                                intent.setClass(ctx, BoutiqueCorporate.class);
                                ctx.startActivity(intent);
                                connexionActivity.finish();
                                break;
                        }
                        break;

                    case 4:
                        //professionnel
                        switch (id_role){
                            case 6:
                                intent.setClass(ctx, BoutiqueActivity.class);
                                ctx.startActivity(intent);
                                connexionActivity.finish();
                                break;
                        }
                        break;


                }

            // new DownloadDataRequestHttp(ctx).execute(utilisateur.getTokenIdentification()); // get les produits
           //   new CategoriesRequestHttp(ctx).execute(utilisateur.getTokenIdentification()); // get les catégories
                 // Log.d("",new SharedePreferenceUser(ctx,utilisateur).saveSharedPreference())

            }
            else {
                Toast.makeText(ctx, "Identifiant ou Mot de passe incorect.", Toast.LENGTH_LONG).show();
            }
        }
        else {
            Toast.makeText(ctx, "Erreur de connexion à la base de donnée.", Toast.LENGTH_LONG).show();
        }

    }
}





























