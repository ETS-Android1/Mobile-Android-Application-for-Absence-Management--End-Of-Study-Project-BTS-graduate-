package com.prof.amine.myprof;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ActivateAppartenance extends AppCompatActivity {
    private Button activateAppar1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activate_appartenance);

        activateAppar1=(Button)findViewById(R.id.BtnActivateAppar1);
        activateAppar1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toSplash = new Intent(getApplicationContext(),Institution.class);
                startActivity(toSplash);
                finish();
            }
        });
    }
}
