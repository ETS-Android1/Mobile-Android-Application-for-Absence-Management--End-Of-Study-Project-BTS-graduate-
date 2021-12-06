package com.prof.amine.myprof;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Seance extends AppCompatActivity {
    private ImageButton returnToAcc;
    private Button absents,saveSeance;
    private TextView dateSeance;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seance);

        returnToAcc=(ImageButton)findViewById(R.id.btnReturnToAcceuil);
        returnToAcc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toSplash = new Intent(getApplicationContext(),Accueil.class);
                startActivity(toSplash);
                finish();
            }
        });

        absents=(Button)findViewById(R.id.BtnAbsents);
        absents.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toSplash = new Intent(getApplicationContext(),ListeAbsents.class);
                startActivity(toSplash);
                finish();
            }
        });
        saveSeance=(Button)findViewById(R.id.BtnSaveSeance);
        saveSeance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toSplash = new Intent(getApplicationContext(),GeneralSeance.class);
                startActivity(toSplash);
                finish();
            }
        });

        Calendar c = Calendar.getInstance();
        SimpleDateFormat dateformat = new SimpleDateFormat("dd/MM/yyyy");
        String myDate = dateformat.format(c.getTime());
        dateSeance=(TextView)findViewById(R.id.lblDate);
        dateSeance.setText(myDate);
    }
}
