package com.example.arsene.mamieclafoutisandroid;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ErrorActivity extends Activity {

    Context ctx;
    Button btnRetourErreur;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_error);
        ctx = this;
        btnRetourErreur = findViewById(R.id.bttnRetourError);

        btnRetourErreur.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ctx, BoutiqueActivity.class);
                startActivity(intent);

            }
        });

    }
}
