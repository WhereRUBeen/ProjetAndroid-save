package entities;

import java.io.Serializable;

/**
 * Created by mayammouarangue on 24/11/17.
 */

public class Ingredient_patte implements Serializable{
    // attributs
    private int ingredient_id;
    private int patte_id;
    private String quantite;

    //contructeur


    public Ingredient_patte(int ingredient_id, int patte_id, String quantite) {
        this.ingredient_id = ingredient_id;
        this.patte_id = patte_id;
        this.quantite = quantite;
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


}
