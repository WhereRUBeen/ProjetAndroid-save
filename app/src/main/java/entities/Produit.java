package entities;

import java.io.Serializable;

import java.util.ArrayList;

import services.C;

/**
 * Created by mayammouarangue on 24/11/17.
 */

public class Produit implements Serializable{
    //attributs
    private int id;
    private String nom;
    private Categorie categorie;

    private String description;
    private Float prix;
    private boolean estVisible;
    private String reference;
    private Float poid;
    private Unite unite;
    private ArrayList<ImageList> imageList;
    private int quantite;





    // CONSTRUCTEUR


    public Produit(int id, String nom, Categorie categorie, String description, Float prix, Float poid, Unite unite, ArrayList<ImageList> srcImage, int quantite) {
        this.id = id;
        this.nom = nom;
        this.categorie = categorie;
        this.description = description;
        this.prix = prix;
        this.poid = poid;
        this.unite = unite;
        this.imageList = srcImage;
        this.quantite = quantite;
    }

    public Produit(int id, String nom, String description, Float prix, String reference, Float poid, int unite_id) {
        this.id = id;
        this.nom = nom;

        this.description = description;
        this.prix = prix;
        this.estVisible = estVisible;
        this.reference = reference;
        this.poid = poid;

    }

    // constructeur testManager
    public Produit(int id, String nom, Float prix) {
        this.id = id;
        this.nom = nom;
        this.prix = prix;
    }
/*
    //constructeur testManager avec id catégorie
    public Produit(int id, String nom, int categorie_id, Float prix) {
        this.id = id;
        this.nom = nom;
        this.categorie_id = categorie_id;
        this.prix = prix;
    }*/

    //constructeur testManager avec  catégorie
    public Produit(int id, String nom, Categorie categorie, Float prix) {
        this.id = id;
        this.nom = nom;
        this.categorie = categorie;
        this.prix = prix;
    }
    // constructeur testManager avec catégrorie et quantite
    public Produit(int id, String nom, Categorie categorie, Float prix, int quantite) {
        this.id = id;
        this.nom = nom;
        this.categorie = categorie;
        this.prix = prix;
        this.quantite = quantite;
    }

    public Produit(String nom, String description, Float prix, String reference, Float poid) {
        this.nom = nom;
        this.description = description;
        this.prix = prix;
        this.reference = reference;
        this.poid = poid;
    }

    // constructeur commande
    public Produit(int id, int quantite) {
        this.id = id;
        this.quantite = quantite;
    }

//constructeur


    public Unite getUnite() {
        return unite;
    }

    public void setUnite(Unite unite) {
        this.unite = unite;
    }



    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    // getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }



    public Float getPrix() {
        return prix;
    }

    public void setPrix(Float prix) {
        this.prix = prix;
    }

    public boolean isEstVisible() {
        return estVisible;
    }

    public void setEstVisible(boolean estVisible) {
        this.estVisible = estVisible;
    }

    public Float getPoid() {
        return poid;
    }

    public void setPoid(Float poid) {
        this.poid = poid;
    }

    public ArrayList<ImageList> getImageList() {
        return imageList;
    }

    public void setImageList(ArrayList<ImageList> imageList) {
        this.imageList = imageList;
    }
}
