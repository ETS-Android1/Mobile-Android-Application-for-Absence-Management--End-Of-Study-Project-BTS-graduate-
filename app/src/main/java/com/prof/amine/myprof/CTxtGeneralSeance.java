package com.prof.amine.myprof;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.prof.amine.myprof.adapters.ctxt_GS_adapter;
import com.prof.amine.myprof.models.ctxt_GS_item;

import java.util.ArrayList;
import java.util.List;

public class CTxtGeneralSeance extends AppCompatActivity {
    private ImageButton returnToAcc;
    private Button returnToSceDone;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ctxt_general_seance);

        returnToAcc=(ImageButton)findViewById(R.id.btnReturnToAcceuil);
        returnToAcc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toSplash = new Intent(getApplicationContext(),Accueil.class);
                startActivity(toSplash);
                finish();
            }
        });

        returnToSceDone=(Button)findViewById(R.id.btnReturnToSceDone);
        returnToSceDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toSplash = new Intent(getApplicationContext(),SeancesDone.class);
                startActivity(toSplash);
                finish();
            }
        });

        //list of items
        List<ctxt_GS_item> itemList = new ArrayList<>();
        itemList.add(new ctxt_GS_item("N°33   16/05/2018"));
        itemList.add(new ctxt_GS_item("N°32   09/05/2018"));
        itemList.add(new ctxt_GS_item("N°31   02/05/2018"));

        //get listView
        ListView myListView=findViewById(R.id.list_view_ctxt_GS);
        myListView.setAdapter((ListAdapter) new ctxt_GS_adapter(this,itemList,getSupportFragmentManager()));
    }
}
