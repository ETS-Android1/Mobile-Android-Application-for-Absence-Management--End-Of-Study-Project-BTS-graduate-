package com.prof.amine.myprof;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Subscribe extends AppCompatActivity {
    private Button subscribe,goToAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subscribe);

        subscribe=(Button)findViewById(R.id.BtnSubscribe);
        subscribe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toSplash = new Intent(getApplicationContext(),Authentification.class);
                startActivity(toSplash);
                finish();
            }
        });

        goToAuth=(Button)findViewById(R.id.btnReturnToAuth);
        goToAuth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toSplash = new Intent(getApplicationContext(),Authentification.class);
                startActivity(toSplash);
                finish();
            }
        });
    }
}
