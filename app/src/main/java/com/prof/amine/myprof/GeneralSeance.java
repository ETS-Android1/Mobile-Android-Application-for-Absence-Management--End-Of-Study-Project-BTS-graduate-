package com.prof.amine.myprof;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.prof.amine.myprof.adapters.gs_adapter;
import com.prof.amine.myprof.models.gs_item;

import java.util.ArrayList;
import java.util.List;

public class GeneralSeance extends AppCompatActivity {
    private ImageButton returnToAcc;
    private Button n33_16_05_18,newSeance;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_general_seance);

        returnToAcc=(ImageButton)findViewById(R.id.btnReturnToAcceuil);
        returnToAcc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toSplash = new Intent(getApplicationContext(),Accueil.class);
                startActivity(toSplash);
                finish();
            }
        });

       /* n33_16_05_18=(Button)findViewById(R.id.btnN33_16_05_18);
        n33_16_05_18.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toSplash = new Intent(getApplicationContext(),Seance.class);
                startActivity(toSplash);
                finish();
            }
        });*/
        newSeance=(Button)findViewById(R.id.BtnNewSeance);
        newSeance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toSplash = new Intent(getApplicationContext(),Seance.class);
                startActivity(toSplash);
                finish();
            }
        });
        //list of items
        List<gs_item> itemList = new ArrayList<>();
        itemList.add(new gs_item(33,"N°33   16/05/2018"));
        itemList.add(new gs_item(32,"N°32   09/05/2018"));
        itemList.add(new gs_item(31,"N°31   02/05/2018"));

        //get listView
        ListView myListView=findViewById(R.id.list_view_GS);
        myListView.setAdapter((ListAdapter) new gs_adapter(this,itemList,getSupportFragmentManager()));

    }
}
