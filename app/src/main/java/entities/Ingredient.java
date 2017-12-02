package entities;

/**
 * Created by mayammouarangue on 24/11/17.
 */

public class Ingredient {
    // attributs
    private int id;
    private String denomination;
    private int quantite;
    private int unite_id;



    //constructeur Ingredient
    public Ingredient(int id, String denomination, int quantite, int unite_id) {
        this.id = id;
        this.denomination = denomination;
        this.quantite = quantite;
        this.unite_id = unite_id;
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


    public int getUnite_id() {
        return unite_id;
    }

    public void setUnite_id(int unite_id) {
        this.unite_id = unite_id;
    }
}
