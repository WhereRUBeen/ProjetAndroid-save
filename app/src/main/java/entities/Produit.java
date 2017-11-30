package entities;

/**
 * Created by mayammouarangue on 24/11/17.
 */

public class Produit {
    //attributs
    private int id;
    private String nom;
   // private Categorie categorie;
    private int categorie_id;
    private String description;
    private Float prix;
    private boolean estVisible;
    private String reference;
    private Float poid;
    private int unite_id;

    public Produit(int id, String nom, int categorie_id, String description, Float prix, String reference, Float poid, int unite_id) {
        this.id = id;
        this.nom = nom;
        this.categorie_id = categorie_id;
        this.description = description;
        this.prix = prix;
        this.estVisible = estVisible;
        this.reference = reference;
        this.poid = poid;
        this.unite_id = unite_id;
    }

    public Produit(String nom, String description, Float prix, String reference, Float poid, int unite_id) {
        this.nom = nom;
        this.description = description;
        this.prix = prix;
        this.reference = reference;
        this.poid = poid;
        this.unite_id = unite_id;
    }

    public int getCategorie_id() {
        return categorie_id;
    }

    public void setCategorie_id(int categorie_id) {
        this.categorie_id = categorie_id;
    }

//constructeur




    // getters and setters
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }



    public Float getPrix() {
        return prix;
    }

    public void setPrix(Float prix) {
        this.prix = prix;
    }

    public boolean isEstVisible() {
        return estVisible;
    }

    public void setEstVisible(boolean estVisible) {
        this.estVisible = estVisible;
    }

    public Float getPoid() {
        return poid;
    }

    public void setPoid(Float poid) {
        this.poid = poid;
    }

    public int getUnite_id() {
        return unite_id;
    }

    public void setUnite_id(int unite_id) {
        this.unite_id = unite_id;
    }
}
