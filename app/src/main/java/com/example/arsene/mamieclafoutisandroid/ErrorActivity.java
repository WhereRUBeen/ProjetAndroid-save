package com.example.arsene.mamieclafoutisandroid;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_bar, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        String msg = "";

        switch (item.getItemId()){

            case R.id.deconnection:
                msg = "Vous etes deconnecter";
                Intent intent = new Intent(ctx,ConnexionActivity.class);
                ErrorActivity.this.finish();
                startActivity(intent);
        }
        Toast.makeText(getBaseContext(), msg, Toast.LENGTH_SHORT).show();
        return super.onOptionsItemSelected(item);
    }
}
