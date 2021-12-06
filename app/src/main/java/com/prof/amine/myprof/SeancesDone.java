package com.prof.amine.myprof;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.prof.amine.myprof.adapters.seanDone_adapter;
import com.prof.amine.myprof.models.seanDone_item;

import java.util.ArrayList;
import java.util.List;

public class SeancesDone extends AppCompatActivity {
    private ImageButton returnToAcc;
    private Button n33_16_05_18;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seances_done);

        returnToAcc=(ImageButton)findViewById(R.id.btnReturnToAcceuil);
        returnToAcc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toSplash = new Intent(getApplicationContext(),Accueil.class);
                startActivity(toSplash);
                finish();
            }
        });

        /*n33_16_05_18=(Button)findViewById(R.id.btnN33_16_05_18);
        n33_16_05_18.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toSplash = new Intent(getApplicationContext(),CTxtGeneralSeance.class);
                startActivity(toSplash);
                finish();
            }
        });*/
        //list of items
        List<seanDone_item> itemList = new ArrayList<>();
        itemList.add(new seanDone_item(33,"N°33   16/05/2018"));
        itemList.add(new seanDone_item(32,"N°32   09/05/2018"));
        itemList.add(new seanDone_item(31,"N°31   02/05/2018"));

        //get listView
        ListView myListView=findViewById(R.id.list_view_seancesDone);
        myListView.setAdapter((ListAdapter) new seanDone_adapter(this,itemList,getSupportFragmentManager()));
    }
}
