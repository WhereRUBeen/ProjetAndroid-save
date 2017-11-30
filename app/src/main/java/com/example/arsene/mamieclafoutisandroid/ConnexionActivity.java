package com.example.arsene.mamieclafoutisandroid;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import entities.Utilisateur;
import com.example.arsene.mamieclafoutisandroid.utils.ConnexionRequestHttp;

public class ConnexionActivity extends Activity {

    Context ctx;
    EditText inputId;
    EditText inputPwd;
    Button bttnConnexion;
    ConnexionActivity connexionActivity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connexion);
        ctx =this;
        connexionActivity = this;
        inputId = (EditText) findViewById(R.id.inputIdentifiant);
        inputPwd = (EditText) findViewById(R.id.inputPwd);
        bttnConnexion = (Button) findViewById(R.id.bttnConnexion);


        // listen sur la bttn connexion
        bttnConnexion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String id = inputId.getText().toString();
                String pwd = inputPwd.getText().toString();

                Utilisateur user = new Utilisateur(id,pwd);

               new ConnexionRequestHttp(ctx,connexionActivity).execute("logIn",user.getUserName(),user.getPassword());

            }
        });

    }
}
