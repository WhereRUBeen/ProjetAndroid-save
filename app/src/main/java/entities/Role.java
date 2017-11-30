package entities;

/**
 * Created by mayammouarangue on 24/11/17.
 */

public class Role {
    // attributs
    private int id;
    private String titre;

    // constructeur

    public Role(int id) {
        this.id = id;
    }

    public Role(int id, String titre) {
        this.id = id;
        this.titre = titre;
    }

    // getters et setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }
}
