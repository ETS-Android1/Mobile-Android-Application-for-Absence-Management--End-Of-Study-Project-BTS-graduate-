package com.prof.amine.myprof;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.prof.amine.myprof.adapters.listeAbsents_adapter;
import com.prof.amine.myprof.models.listeAbsents_item;

import java.util.ArrayList;
import java.util.List;

public class ListeAbsents extends AppCompatActivity {
    private ImageButton returnToAcc,imgAbsent1;
    private Button nomPrenomAbsent1,confirmAbs;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liste_absents);

        returnToAcc=(ImageButton)findViewById(R.id.btnReturnToAcceuil);
        returnToAcc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toSplash = new Intent(getApplicationContext(),Accueil.class);
                startActivity(toSplash);
                finish();
            }
        });

       /* imgAbsent1=(ImageButton)findViewById(R.id.btnImgAbsent1);
        imgAbsent1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toSplash = new Intent(getApplicationContext(),StudentProfil.class);
                startActivity(toSplash);
                finish();
            }
        });
        nomPrenomAbsent1=(Button)findViewById(R.id.btnNomPrenomAbsent1);
        nomPrenomAbsent1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toSplash = new Intent(getApplicationContext(),StudentProfil.class);
                startActivity(toSplash);
                finish();
            }
        });*/
        confirmAbs=(Button)findViewById(R.id.BtnConfirmAbs);
        confirmAbs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("kjkjk");
                Intent toSplash = new Intent(getApplicationContext(),Seance.class);
                startActivity(toSplash);
                finish();
            }
        });
        //list of items
        List<listeAbsents_item> itemList = new ArrayList<>();
        itemList.add(new listeAbsents_item(1,1,1,"محمد أمين مخايبو","mepng",true));
        itemList.add(new listeAbsents_item(2,2,2,"محسن أنونيم","personnel",true));
        itemList.add(new listeAbsents_item(3,3,3," xxxxxxxxxxxxx ","personnel",true));

        //get listView
        ListView myListView=findViewById(R.id.list_view_listeAbsents);
        myListView.setAdapter((ListAdapter) new listeAbsents_adapter(this,itemList,getSupportFragmentManager()));
    }
}
