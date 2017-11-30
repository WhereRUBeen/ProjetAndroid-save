package entities;

/**
 * Created by mayammouarangue on 27/11/17.
 */

public class Type_Etablissement {
    private int id;
    private String type;

    // constructeur
    public Type_Etablissement(int id, String type) {
        this.id = id;
        this.type = type;
    }

    public Type_Etablissement(int id) {
        this.id = id;
    }

    //getters et setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
