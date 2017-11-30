package entities;

/**
 * Created by mayammouarangue on 24/11/17.
 */

public class Ingredient {
    // attributs
    private int id;
    private String denomination;
    private int quantite;
    private int unite_ingredient;

    //constructeur Ingredient
    public Ingredient(int id, String denomination, int quantite, int unite_ingredient) {
        this.id = id;
        this.denomination = denomination;
        this.quantite = quantite;
        this.unite_ingredient = unite_ingredient;
    }

    // getters et setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDenomination() {
        return denomination;
    }

    public void setDenomination(String denomination) {
        this.denomination = denomination;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public int getUnite_ingredient() {
        return unite_ingredient;
    }

    public void setUnite_ingredient(int unite_ingredient) {
        this.unite_ingredient = unite_ingredient;
    }
}
