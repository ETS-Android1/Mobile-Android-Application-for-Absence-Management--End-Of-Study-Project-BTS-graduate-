package com.prof.amine.myprof;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class NewNovelty extends AppCompatActivity {
    private ImageButton returnToAcc;
    private Button confirmNov,closeNov;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_novelty);

        returnToAcc=(ImageButton)findViewById(R.id.btnReturnToAcceuil);
        returnToAcc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toSplash = new Intent(getApplicationContext(),Accueil.class);
                startActivity(toSplash);
                finish();
            }
        });

        confirmNov=(Button)findViewById(R.id.BtnConfirmNov);
        confirmNov.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toSplash = new Intent(getApplicationContext(),Novelties.class);
                startActivity(toSplash);
                finish();
            }
        });
        closeNov=(Button)findViewById(R.id.BtnCloseNov);
        closeNov.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toSplash = new Intent(getApplicationContext(),Novelties.class);
                startActivity(toSplash);
                finish();
            }
        });
    }
}
