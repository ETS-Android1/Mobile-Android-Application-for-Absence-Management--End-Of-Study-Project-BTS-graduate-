package com.prof.amine.myprof;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Authentification extends AppCompatActivity {
    private Button entrer,inscrire;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_authentification);

        entrer=(Button)findViewById(R.id.BtnAuthEntrer);
        entrer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toSplash = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(toSplash);
                finish();
            }
        });

        inscrire=(Button)findViewById(R.id.btnGoToSubscribe);
        inscrire.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toSplash = new Intent(getApplicationContext(),Subscribe.class);
                startActivity(toSplash);
                finish();
            }
        });
    }
}
