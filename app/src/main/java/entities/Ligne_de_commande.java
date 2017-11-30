package entities;

/**
 * Created by mayammouarangue on 24/11/17.
 */

public class Ligne_de_commande {
    // attributs
    private int commande_id;
    private int produit_idproduit;
    private int quantite;

    //constructeur
    public Ligne_de_commande() {
    }

    public Ligne_de_commande(int commande_id, int produit_idproduit, int quantite) {
        this.commande_id = commande_id;
        this.produit_idproduit = produit_idproduit;
        this.quantite = quantite;
    }
    //getters et setters

    public int getCommande_id() {
        return commande_id;
    }

    public void setCommande_id(int commande_id) {
        this.commande_id = commande_id;
    }

    public int getProduit_idproduit() {
        return produit_idproduit;
    }

    public void setProduit_idproduit(int produit_idproduit) {
        this.produit_idproduit = produit_idproduit;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }
}
