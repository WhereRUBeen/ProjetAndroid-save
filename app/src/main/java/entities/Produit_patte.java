package entities;

/**
 * Created by mayammouarangue on 24/11/17.
 */

public class Produit_patte {
    // attributs
    private Float poid;
    private int produit_id;
    private int patte_id;

    // constructeur
    public Produit_patte(Float poid, int produit_id, int patte_id) {
        this.poid = poid;
        this.produit_id = produit_id;
        this.patte_id = patte_id;
    }
    //getters et setters
    public Float getPoid() {
        return poid;
    }

    public void setPoid(Float poid) {
        this.poid = poid;
    }

    public int getProduit_id() {
        return produit_id;
    }

    public void setProduit_id(int produit_id) {
        this.produit_id = produit_id;
    }

    public int getPatte_id() {
        return patte_id;
    }

    public void setPatte_id(int patte_id) {
        this.patte_id = patte_id;
    }
}
