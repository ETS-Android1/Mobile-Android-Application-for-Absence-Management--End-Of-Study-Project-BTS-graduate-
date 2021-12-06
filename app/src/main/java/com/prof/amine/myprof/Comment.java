package com.prof.amine.myprof;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class Comment extends AppCompatActivity {
    private ImageButton returnToAcc;
    private Button confirmComm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comment);

        returnToAcc=(ImageButton)findViewById(R.id.btnReturnToAcceuil);
        returnToAcc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toSplash = new Intent(getApplicationContext(),Accueil.class);
                startActivity(toSplash);
                finish();
            }
        });

        confirmComm=(Button)findViewById(R.id.BtnConfirmComm);
        confirmComm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toSplash = new Intent(getApplicationContext(),NoveltyDetails.class);
                startActivity(toSplash);
                finish();
            }
        });
    }
}
