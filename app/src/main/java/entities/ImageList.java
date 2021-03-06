package entities;

import java.io.Serializable;

/**
 * Created by Been WhereU on 2017-12-01.
 */

public class ImageList implements Serializable{
    private int id;
    private String src_img_mobile;
    private String imageList;
    private int produit_id;
    private String formatWeb;

    public ImageList(int id, String src_img_mobile, int produit_id) {
        this.id = id;
        this.src_img_mobile = src_img_mobile;
        this.produit_id = produit_id;
    }

    public String getFormatWeb() {
        return formatWeb;
    }

    public void setFormatWeb(String formatWeb) {
        this.formatWeb = formatWeb;
    }

    public String getImageList() {
        return imageList;
    }

    public void setImageList(String imageList) {
        this.imageList = imageList;
    }

    public String getSrc_img_mobile() {
        return src_img_mobile;
    }

    public void setSrc_img_mobile(String src_img_mobile) {
        this.src_img_mobile = src_img_mobile;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }



    public int getProduit_id() {
        return produit_id;
    }

    public void setProduit_id(int produit_id) {
        this.produit_id = produit_id;
    }
}



