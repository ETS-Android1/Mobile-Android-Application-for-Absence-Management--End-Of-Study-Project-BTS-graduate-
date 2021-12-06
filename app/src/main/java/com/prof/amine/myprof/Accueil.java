package com.prof.amine.myprof;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Accueil extends AppCompatActivity {
    private Button account,institution,novelties,seances,cahierTextes,out;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accueil);

        account=(Button)findViewById(R.id.btnFullName);
        account.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toSplash = new Intent(getApplicationContext(),Account.class);
                startActivity(toSplash);
                finish();
            }
        });

        institution=(Button)findViewById(R.id.btnInstitution);
        institution.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toSplash = new Intent(getApplicationContext(),InstitutionParameters.class);
                startActivity(toSplash);
                finish();
            }
        });

        novelties=(Button)findViewById(R.id.btnNouveautes);
        novelties.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toSplash = new Intent(getApplicationContext(),Novelties.class);
                startActivity(toSplash);
                finish();
            }
        });

        seances=(Button)findViewById(R.id.btnGestSeances);
        seances.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toSplash = new Intent(getApplicationContext(),EmploiTemps.class);
                startActivity(toSplash);
                finish();
            }
        });
        cahierTextes=(Button)findViewById(R.id.btnCahierTexte);
        cahierTextes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toSplash = new Intent(getApplicationContext(),SeancesDone.class);
                startActivity(toSplash);
                finish();
            }
        });

        out=(Button)findViewById(R.id.btnAccOut);
        out.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toSplash = new Intent(getApplicationContext(),Authentification.class);
                startActivity(toSplash);
                finish();
            }
        });
    }
}
