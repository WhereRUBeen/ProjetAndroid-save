package entities;

/**
 * Created by mayammouarangue on 24/11/17.
 */

public class Patte {
    // attributs
    private int id;
    private String nom;

    // constructeur
    public Patte(int id, String nom) {
        this.id = id;
        this.nom = nom;
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
}
