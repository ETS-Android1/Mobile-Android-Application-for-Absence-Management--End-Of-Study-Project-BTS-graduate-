package com.prof.amine.myprof;

import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

public class Account extends AppCompatActivity{
    private ImageButton returnToAcc;
    private Button plusInfos;

  /*  View myView;
    //@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        myView=inflater.inflate(R.layout.activity_account,container,false);
        return myView;
    }*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);

        returnToAcc=(ImageButton)findViewById(R.id.btnReturnToAcceuil);
        returnToAcc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toSplash = new Intent(getApplicationContext(),Accueil.class);
                startActivity(toSplash);
                finish();
            }
        });

        plusInfos=(Button)findViewById(R.id.BtnMoreInfos);
        plusInfos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toSplash = new Intent(getApplicationContext(),MoreInfos.class);
                startActivity(toSplash);
                finish();
            }
        });
    }


}
