package entities;

/**
 * Created by mayammouarangue on 24/11/17.
 */

public class Production {
    //attributs
    private int utilisateur_id;
    private int produit_id;
    private int quantite;
    private Long date;


    //constructeur
    public Production(int utilisateur_id, int produit_id, int quantite, Long date) {
        this.utilisateur_id = utilisateur_id;
        this.produit_id = produit_id;
        this.quantite = quantite;
        this.date = date;
    }

    //getters et setters
    public int getUtilisateur_id() {
        return utilisateur_id;
    }

    public void setUtilisateur_id(int utilisateur_id) {
        this.utilisateur_id = utilisateur_id;
    }

    public int getProduit_id() {
        return produit_id;
    }

    public void setProduit_id(int produit_id) {
        this.produit_id = produit_id;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public Long getDate() {
        return date;
    }

    public void setDate(Long date) {
        this.date = date;
    }
}
