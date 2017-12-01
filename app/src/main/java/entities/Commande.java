package entities;

/**
 * Created by mayammouarangue on 24/11/17.
 */

public class Commande {

    // attributs
    private int id;
    private int utilisateur_id;
    private Long date;
    private int valide;
    private int produit_id;
    private int quantite;

    // constructeur

    public Commande(int id, int utilisateur_id, Long date, int valide) {
        this.id = id;
        this.utilisateur_id = utilisateur_id;
        this.date = date;
        this.valide = valide;
    }

    public Commande(int id, int utilisateur_id, int produit_id, int quantite) {
        this.id = id;
        this.utilisateur_id = utilisateur_id;
        this.produit_id = produit_id;
        this.quantite = quantite;
    }

    // getters et setters


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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUtilisateur_id() {
        return utilisateur_id;
    }

    public void setUtilisateur_id(int utilisateur_id) {
        this.utilisateur_id = utilisateur_id;
    }

    public Long getDate() {
        return date;
    }

    public void setDate(Long date) {
        this.date = date;
    }

    public int getValide() {
        return valide;
    }

    public void setValide(int valide) {
        this.valide = valide;
    }
}
