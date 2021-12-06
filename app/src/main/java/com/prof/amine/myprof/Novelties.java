package com.prof.amine.myprof;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.prof.amine.myprof.adapters.novelty_adapter;
import com.prof.amine.myprof.models.novelty_item;

import java.util.ArrayList;
import java.util.List;

public class Novelties extends AppCompatActivity {
    private ImageButton returnToAcc;
    private Button nv1,newNovelty;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_novelties);

        returnToAcc=(ImageButton)findViewById(R.id.btnReturnToAcceuil);
        returnToAcc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toSplash = new Intent(getApplicationContext(),Accueil.class);
                startActivity(toSplash);
                finish();
            }
        });

       /* nv1=(Button)findViewById(R.id.btnNv1);
        nv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toSplash = new Intent(getApplicationContext(),NoveltyDetails.class);
                startActivity(toSplash);
                finish();
            }
        });*/

        newNovelty=(Button)findViewById(R.id.BtnNewNovelty);
        newNovelty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toSplash = new Intent(getApplicationContext(),NewNovelty.class);
                startActivity(toSplash);
                finish();
            }
        });

        //list of items
        List<novelty_item> itemList = new ArrayList<>();
        itemList.add(new novelty_item(1,"فرض محروس في مادةTransact SQL بتاريخ:02/05/2018؛مشاركة:ذ.حميد"));
        itemList.add(new novelty_item(2,"الأستاذ*جمال أقبلي* في رخصة مرضية من 12/02/2018 إلى 15/02/2018؛مشاركة:الإدارة"));
        itemList.add(new novelty_item(3," ******** "));

        //get listView
        ListView myListView=findViewById(R.id.list_view_novelties);
        myListView.setAdapter((ListAdapter) new novelty_adapter(this,itemList,getSupportFragmentManager()));
    }
}
