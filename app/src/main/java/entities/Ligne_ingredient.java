package entities;

/**
 * Created by mayammouarangue on 24/11/17.
 */

public class Ligne_ingredient {
    // attributs
    private int ingredient_id;
    private int produit_id;
    private Float quantite;
    private String unite;

    // constructeur

    public Ligne_ingredient(int ingredient_id, int produit_id, Float quantite, String unite) {
        this.ingredient_id = ingredient_id;
        this.produit_id = produit_id;
        this.quantite = quantite;
        this.unite = unite;
    }

    // getters et setters

    public int getIngredient_id() {
        return ingredient_id;
    }

    public void setIngredient_id(int ingredient_id) {
        this.ingredient_id = ingredient_id;
    }

    public int getProduit_id() {
        return produit_id;
    }

    public void setProduit_id(int produit_id) {
        this.produit_id = produit_id;
    }

    public Float getQuantite() {
        return quantite;
    }

    public void setQuantite(Float quantite) {
        this.quantite = quantite;
    }

    public String getUnite() {
        return unite;
    }

    public void setUnite(String unite) {
        this.unite = unite;
    }
}
