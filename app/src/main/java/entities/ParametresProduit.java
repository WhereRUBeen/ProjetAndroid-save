package entities;

import java.io.Serializable;

/**
 * Created by mayammouarangue on 30/11/17.
 */

public class ParametresProduit implements Serializable{
    private String url;
    private String produitJsonType;
    private String parametreList;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getProduitJsonType() {
        return produitJsonType;
    }

    public void setProduitJsonType(String produitJsonType) {
        this.produitJsonType = produitJsonType;
    }

    public String getParametreList() {
        return parametreList;
    }

    public void setParametreList(String parametreList) {
        this.parametreList = parametreList;
    }
}
