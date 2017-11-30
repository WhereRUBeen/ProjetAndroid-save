package entities;

/**
 * Created by mayammouarangue on 24/11/17.
 */

public class Adresse {
    // attributs
    private int id;
    private int numero_rue;
    private String nom_rue;
    private String ville;
    private String province;
    private String code_postal;
    private String pays;

    // constructeur
    public Adresse(int id, int numero_rue, String nom_rue, String ville, String province, String code_postal, String pays) {
        this.id = id;
        this.numero_rue = numero_rue;
        this.nom_rue = nom_rue;
        this.ville = ville;
        this.province = province;
        this.code_postal = code_postal;
        this.pays = pays;
    }

    public Adresse(int id){
        this.id = id;
    }

    // getters and setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumero_rue() {
        return numero_rue;
    }

    public void setNumero_rue(int numero_rue) {
        this.numero_rue = numero_rue;
    }

    public String getNom_rue() {
        return nom_rue;
    }

    public void setNom_rue(String nom_rue) {
        this.nom_rue = nom_rue;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCode_postal() {
        return code_postal;
    }

    public void setCode_postal(String code_postal) {
        this.code_postal = code_postal;
    }

    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }
}
