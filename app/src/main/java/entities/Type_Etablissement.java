package entities;

import java.io.Serializable;

/**
 * Created by mayammouarangue on 27/11/17.
 */

public class Type_Etablissement implements Serializable{
    private int id;
    private String type;
    private int type_id;

    // constructeur
    public Type_Etablissement(int id, String type) {
        this.id = id;
        this.type = type;
    }

    public Type_Etablissement(int id, int type_id) {
        this.id = id;
        this.type_id = type_id;
    }

    public Type_Etablissement(int id) {
        this.id = id;
    }

    //getters et setters

    public int getType_id() {
        return type_id;
    }

    public void setType_id(int type_id) {
        this.type_id = type_id;
    }

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
