package entities;

/**
 * Created by mayammouarangue on 24/11/17.
 */

public class Categorie {
    // attributs
    private int id;
    private String denomination;

    // constructeur
    public Categorie(int id, String denomination) {
        this.id = id;
        this.denomination = denomination;
    }

    // getters and setters
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
}
