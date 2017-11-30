package com.example.arsene.mamieclafoutisandroid.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

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
        editor.putInt("id",utilisateur.getId());
        editor.putString("userName",utilisateur.getUserName());
        editor.putString("nom",utilisateur.getNom());
        editor.putString("prenom",utilisateur.getPrenom());
        editor.commit();
    }

    public Utilisateur getUserSharedPreference(){
        utilisateur = null;
        SharedPreferences sharedPreferences= PreferenceManager.getDefaultSharedPreferences(ctx);

        int id = sharedPreferences.getInt("id",0);
        String nom = sharedPreferences.getString("nom","");
        String prenom = sharedPreferences.getString("prenom","");
        String userName = sharedPreferences.getString("userName","");

        utilisateur = new Utilisateur(id,nom,prenom,userName);
        return utilisateur;
    }
}
