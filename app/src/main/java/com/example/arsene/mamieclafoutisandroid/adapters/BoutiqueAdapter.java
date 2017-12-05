package com.example.arsene.mamieclafoutisandroid.adapters;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.arsene.mamieclafoutisandroid.R;
import com.example.arsene.mamieclafoutisandroid.utils.DisplayImage;

import java.util.ArrayList;
import java.util.List;

import entities.ImageList;
import entities.Produit;
import managers.Manager_src_image;

/**
 * Created by mayammouarangue on 25/11/17.
 */

public class BoutiqueAdapter extends ArrayAdapter<Produit> {
    //attributs
    Context ctx;
    int layoutId;
    //Arraylist contenant les Images
    ArrayList<ImageList> lesImages;
    Handler handler;
    Drawable drawable;


    public BoutiqueAdapter(Context context, int resource, List<Produit> objects) {
        super(context, resource, objects);
        ctx = context;
        layoutId =resource;

        // set arraylist images
        lesImages = new ArrayList<>();
        lesImages = Manager_src_image.getAllImage(ctx);
        handler = new Handler();
        Log.d("Images base adapter", lesImages.size()+"");
        drawable = null;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Produit p = getItem(position);

        if (convertView == null){
            LayoutInflater inflater =LayoutInflater.from(ctx);
            convertView = inflater.inflate(layoutId, null);
        }

        // les composants du layout
        // image produit, nom et prix unitaire
        ImageView imageProduit = convertView.findViewById(R.id.boutiqueProduitImgView);
        TextView textViewNomProduit = convertView.findViewById(R.id.boutiqueProduitNomTxtView);
        TextView textViewPrixProduit = convertView.findViewById(R.id.textViewBoutiquePrixProd);


        for(ImageList img : lesImages){
            Log.d("lien",img.getSrc_img_mobile()+"");

       }

        // set les composants
        // image
        Log.d("drawable",drawable+"");
        imageProduit.setImageDrawable(drawable);
        textViewNomProduit.setText(p.getNom());
        textViewPrixProduit.setText(p.getPrix()+"");


        return convertView;
    }
}
