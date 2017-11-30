package entities;

/**
 * Created by mayammouarangue on 24/11/17.
 */

public class Ingredient_patte {
    // attributs
    private int ingredient_id;
    private int patte_id;
    private String quantite;
    private String unite;

    //contructeur
    public Ingredient_patte(int ingredient_id, int patte_id, String quantite, String unite) {
        this.ingredient_id = ingredient_id;
        this.patte_id = patte_id;
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

    public int getPatte_id() {
        return patte_id;
    }

    public void setPatte_id(int patte_id) {
        this.patte_id = patte_id;
    }

    public String getQuantite() {
        return quantite;
    }

    public void setQuantite(String quantite) {
        this.quantite = quantite;
    }

    public String getUnite() {
        return unite;
    }

    public void setUnite(String unite) {
        this.unite = unite;
    }
}
