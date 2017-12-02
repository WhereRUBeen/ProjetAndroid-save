package entities;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by mayammouarangue on 30/11/17.
 */

public class ParametresProduit implements Serializable{
    private String url;
    private Produit produitJsonType;
    private ArrayList<Produit> lesProduits;
    private Parametre parametreList;
    private String token;

    public ArrayList<Produit> getLesProduits() {
        return lesProduits;
    }

    public void setLesProduits(ArrayList<Produit> lesProduits) {
        this.lesProduits = lesProduits;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Produit getProduitJsonType() {
        return produitJsonType;
    }

    public void setProduitJsonType(Produit produitJsonType) {
        this.produitJsonType = produitJsonType;
    }

    public Parametre getParametreList() {
        return parametreList;
    }

    public void setParametreList(Parametre parametreList) {
        this.parametreList = parametreList;
    }
}
