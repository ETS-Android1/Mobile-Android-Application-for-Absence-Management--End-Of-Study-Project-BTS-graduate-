package com.prof.amine.myprof;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class Update_novelty extends AppCompatActivity {
    private ImageButton returnToAcc;
    private Button updNov,deleteNov;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_novelty);

        returnToAcc=(ImageButton)findViewById(R.id.btnReturnToAcceuil);
        returnToAcc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toSplash = new Intent(getApplicationContext(),Accueil.class);
                startActivity(toSplash);
                finish();
            }
        });

        updNov=(Button)findViewById(R.id.BtnUpdNov);
        updNov.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toSplash = new Intent(getApplicationContext(),Novelties.class);
                startActivity(toSplash);
                finish();
            }
        });
        deleteNov=(Button)findViewById(R.id.BtnDeleteNov);
        deleteNov.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toSplash = new Intent(getApplicationContext(),Novelties.class);
                startActivity(toSplash);
                finish();
            }
        });
    }
}
