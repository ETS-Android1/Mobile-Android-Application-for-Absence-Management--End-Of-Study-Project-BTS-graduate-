package com.prof.amine.myprof;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MoreInfos extends AppCompatActivity {
    private ImageButton returnToAcc;
    private Button closeMInfos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more_infos);

        returnToAcc=(ImageButton)findViewById(R.id.btnReturnToAcceuil);
        returnToAcc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toSplash = new Intent(getApplicationContext(),Accueil.class);
                startActivity(toSplash);
                finish();
            }
        });

        closeMInfos=(Button)findViewById(R.id.BtnCloseMoreInfos);
        closeMInfos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toSplash = new Intent(getApplicationContext(),Account.class);
                startActivity(toSplash);
                finish();
            }
        });

    }
}
