package entities;

/**
 * Created by mayammouarangue on 24/11/17.
 */

public class Ventes {
    //attributs
    private Long date_horaire;
    private int utilisateur_id;
    private int quantite;
    private int produit_id;
    private int id;

    //constructeur

    public Ventes(Long date_horaire, int utilisateur_id, int quantite, int produit_id, int id) {
        this.date_horaire = date_horaire;
        this.utilisateur_id = utilisateur_id;
        this.quantite = quantite;
        this.produit_id = produit_id;
        this.id = id;
    }

    // getters et setters

    public Long getDate_horaire() {
        return date_horaire;
    }

    public void setDate_horaire(Long date_horaire) {
        this.date_horaire = date_horaire;
    }

    public int getUtilisateur_id() {
        return utilisateur_id;
    }

    public void setUtilisateur_id(int utilisateur_id) {
        this.utilisateur_id = utilisateur_id;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public int getProduit_id() {
        return produit_id;
    }

    public void setProduit_id(int produit_id) {
        this.produit_id = produit_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
