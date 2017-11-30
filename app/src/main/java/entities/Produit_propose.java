package entities;

/**
 * Created by mayammouarangue on 24/11/17.
 */

public class Produit_propose {

    // attributs
    private int id;
    private String description;
    private Long date;
    private int utilisateur_id;
    private String titre;

    //constructeur

    public Produit_propose(int id, String description, Long date, int utilisateur_id, String titre) {
        this.id = id;
        this.description = description;
        this.date = date;
        this.utilisateur_id = utilisateur_id;
        this.titre = titre;
    }


    //getters and setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getDate() {
        return date;
    }

    public void setDate(Long date) {
        this.date = date;
    }

    public int getUtilisateur_id() {
        return utilisateur_id;
    }

    public void setUtilisateur_id(int utilisateur_id) {
        this.utilisateur_id = utilisateur_id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }
}
