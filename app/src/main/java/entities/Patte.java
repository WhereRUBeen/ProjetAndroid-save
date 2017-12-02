package entities;

import java.util.ArrayList;

/**
 * Created by mayammouarangue on 24/11/17.
 */

public class Patte {
    // attributs
    private int id;
    private String nom;
    private float poid;
    private ArrayList<Ingredient> ingredientList;
    private Unite unite;

    // constructeur
    public Patte(int id, String nom) {
        this.id = id;
        this.nom = nom;
    }

    public Patte(int id, String nom, float poid, ArrayList<Ingredient> ingredientList, Unite unite) {
        this.id = id;
        this.nom = nom;
        this.poid = poid;
        this.ingredientList = ingredientList;
        this.unite = unite;
    }

    // getters et setters

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

    public float getPoid() {
        return poid;
    }

    public void setPoid(float poid) {
        this.poid = poid;
    }

    public ArrayList<Ingredient> getIngredientList() {
        return ingredientList;
    }

    public void setIngredientList(ArrayList<Ingredient> ingredientList) {
        this.ingredientList = ingredientList;
    }

    public Unite getUnite() {
        return unite;
    }

    public void setUnite(Unite unite) {
        this.unite = unite;
    }
}
