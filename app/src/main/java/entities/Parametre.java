package entities;

import java.io.Serializable;

/**
 * Created by mayammouarangue on 30/11/17.
 */

public class Parametre implements Serializable {
    String idParam;
    String valeurParam;

    public String getIdParam() {
        return idParam;
    }

    public void setIdParam(String idParam) {
        this.idParam = idParam;
    }

    public String getValeurParam() {
        return valeurParam;
    }

    public void setValeurParam(String valeurParam) {
        this.valeurParam = valeurParam;
    }
}
