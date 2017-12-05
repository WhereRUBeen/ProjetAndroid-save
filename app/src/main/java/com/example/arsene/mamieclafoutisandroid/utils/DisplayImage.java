package com.example.arsene.mamieclafoutisandroid.utils;

import android.graphics.drawable.Drawable;
import android.os.AsyncTask;

import java.io.InputStream;
import java.net.URL;

/**
 * Created by mayammouarangue on 05/12/17.
 */

public class DisplayImage extends AsyncTask<String, Long, String> {

    public static Drawable loadImageFromWebOperations(String url) {
        Drawable d = null;
        try {
            InputStream is = (InputStream) new URL(url).getContent();
           d = Drawable.createFromStream(is, "src name");

        } catch (Exception e) {
            e.printStackTrace();
        }
        return d;
    }


    @Override
    protected String doInBackground(String... strings) {
        return null;
    }
}
