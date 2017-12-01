package com.example.arsene.mamieclafoutisandroid.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.util.Log;

import entities.Utilisateur;

/**
 * Created by mayammouarangue on 30/11/17.
 */

public class SharedePreferenceUser {
    Context ctx;
    Utilisateur utilisateur;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    public SharedePreferenceUser(Context ctx) {
        this.ctx = ctx;
    }

    public SharedePreferenceUser(Context ctx, Utilisateur utilisateur) {
        this.ctx = ctx;
        this.utilisateur = utilisateur;
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this.ctx);
        editor = sharedPreferences.edit();
    }

    public void saveSharedPreference(){
        editor.clear();
        editor.commit();
        editor.putInt("id",utilisateur.getId());
        editor.putString("userName",utilisateur.getUserName());
        editor.putString("nom",utilisateur.getNom());
        editor.putString("prenom",utilisateur.getPrenom());
        editor.putString("token",utilisateur.getTokenIdentification());
        editor.commit();
    }

    public Utilisateur getUserSharedPreference(){
       // utilisateur = null; a ne pas faire
        SharedPreferences sharedPreferences= PreferenceManager.getDefaultSharedPreferences(ctx);

        int id = sharedPreferences.getInt("id",0);
        String nom = sharedPreferences.getString("nom","");
        String prenom = sharedPreferences.getString("prenom","");
        String userName = sharedPreferences.getString("userName","");
        String token = sharedPreferences.getString("token","");

        utilisateur = new Utilisateur(id,nom,prenom,userName,token);
        Log.d("userToken",utilisateur.getTokenIdentification());
        Log.d("user",utilisateur.toString());
        return utilisateur;
    }

    public static void updateToken(Context ctx, String token){
        SharedPreferences sharedPreferences =PreferenceManager.getDefaultSharedPreferences(ctx);;
        SharedPreferences.Editor editor = sharedPreferences.edit();


        editor.putString("token",token);
        editor.commit();
    }
}
