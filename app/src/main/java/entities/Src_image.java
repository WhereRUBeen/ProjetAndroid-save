package entities;

import java.io.Serializable;

/**
 * Created by Been WhereU on 2017-12-01.
 */

public class Src_image implements Serializable{
    private int id;
    private String src_image_taille_normale;
    private String src_image_taille_mobile;
    private int produit_id;


    public Src_image(int id, String src_image_taille_normale, String src_image_taille_mobile, int produit_id) {
        this.id = id;
        this.src_image_taille_normale = src_image_taille_normale;
        this.src_image_taille_mobile = src_image_taille_mobile;
        this.produit_id = produit_id;
    }

    public Src_image(int id, String src_image_taille_mobile, int produit_id) {
        this.id = id;
        this.src_image_taille_mobile = src_image_taille_mobile;
        this.produit_id = produit_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSrc_image_taille_normale() {
        return src_image_taille_normale;
    }

    public void setSrc_image_taille_normale(String src_image_taille_normale) {
        this.src_image_taille_normale = src_image_taille_normale;
    }

    public String getSrc_image_taille_mobile() {
        return src_image_taille_mobile;
    }

    public void setSrc_image_taille_mobile(String src_image_taille_mobile) {
        this.src_image_taille_mobile = src_image_taille_mobile;
    }

    public int getProduit_id() {
        return produit_id;
    }

    public void setProduit_id(int produit_id) {
        this.produit_id = produit_id;
    }
}



