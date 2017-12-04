package com.example.arsene.mamieclafoutisandroid;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import java.util.Calendar;

public class Vente extends Activity {

    Calendar cal = Calendar.getInstance();
    Button btnDate, btnAfficherVente, btnRetourVente;
    Context ctx;
    private int jour,mois,annee;
    EditText date;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vente);
        ctx = this;

        btnAfficherVente = findViewById(R.id.bttnAfficherVente);
        btnRetourVente = findViewById(R.id.bttnRetourVente);
        btnDate = findViewById(R.id.datePickerVente);

        jour = cal.get(Calendar.DAY_OF_MONTH);
        mois = cal.get(Calendar.MONTH);
        annee = cal.get(Calendar.YEAR);

        btnDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateDate();
            }
        });
    }

    private void updateDate(){
        new DatePickerDialog(ctx,d,annee,mois,jour).show();
    }

    DatePickerDialog.OnDateSetListener d = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
            annee = i;
            mois = i1+1;
            jour = i2;
            date.setText(i2 + "/" + i1 + "/" + i);
        }
    };
}
