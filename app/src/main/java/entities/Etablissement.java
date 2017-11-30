package entities;

/**
 * Created by mayammouarangue on 24/11/17.
 */

public class Etablissement {
    // attributs
    private int id;
    private String name;
    private String tel;
    private Type_Etablissement typeEtablissement;
    private Adresse adresse;
    private boolean isVisible;

    // constructeur

    public Etablissement(int id, String name, String tel, Type_Etablissement typeEtablissement, Adresse adresse, boolean isVisible) {
        this.id = id;
        this.name = name;
        this.tel = tel;
        this.typeEtablissement = typeEtablissement;
        this.adresse = adresse;
        this.isVisible = isVisible;
    }


    // getters and setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public boolean isVisible() {
        return isVisible;
    }

    public void setVisible(boolean visible) {
        isVisible = visible;
    }

    public Type_Etablissement getTypeEtablissement() {
        return typeEtablissement;
    }

    public void setTypeEtablissement(Type_Etablissement typeEtablissement) {
        this.typeEtablissement = typeEtablissement;
    }

    public Adresse getAdresse() {
        return adresse;
    }

    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }
}
