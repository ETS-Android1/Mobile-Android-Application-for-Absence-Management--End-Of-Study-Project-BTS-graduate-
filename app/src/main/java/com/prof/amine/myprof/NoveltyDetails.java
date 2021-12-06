package com.prof.amine.myprof;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.prof.amine.myprof.adapters.novDet_adapter;
import com.prof.amine.myprof.models.novDet_item;

import java.util.ArrayList;
import java.util.List;

public class NoveltyDetails extends AppCompatActivity {
    private ImageButton returnToAcc;
    private Button updateNovDet,commPer1,addComment,closeNov;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_novelty_details);

        returnToAcc=(ImageButton)findViewById(R.id.btnReturnToAcceuil);
        returnToAcc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toSplash = new Intent(getApplicationContext(),Accueil.class);
                startActivity(toSplash);
                finish();
            }
        });

        updateNovDet=(Button)findViewById(R.id.BtnUpdateNovDet);
        updateNovDet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toSplash = new Intent(getApplicationContext(),Update_novelty.class);
                startActivity(toSplash);
                finish();
            }
        });
        /*commPer1=(Button)findViewById(R.id.btnCommPer1);
        commPer1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toSplash = new Intent(getApplicationContext(),CommentatorProfil.class);
                startActivity(toSplash);
                finish();
            }
        });*/
        addComment=(Button)findViewById(R.id.BtnAddComment);
        addComment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toSplash = new Intent(getApplicationContext(),Comment.class);
                startActivity(toSplash);
                finish();
            }
        });
        closeNov=(Button)findViewById(R.id.BtnCloseNov);
        closeNov.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toSplash = new Intent(getApplicationContext(),Novelties.class);
                startActivity(toSplash);
                finish();
            }
        });
        //list of items
        List<novDet_item> itemList = new ArrayList<>();
        itemList.add(new novDet_item(1,1,"Est-ce que la documentation est autorisée ?","محمد أمين مخايبو"));
        itemList.add(new novDet_item(2,2,"xxxxxxxxxxxxx","xxxxxxxxxxxxx"));
        itemList.add(new novDet_item(3,3," xxxxxxxxxxxxx ","xxxxxxxxxxxxx"));

        //get listView
        ListView myListView=findViewById(R.id.list_view_noveltyDetails);
        myListView.setAdapter((ListAdapter) new novDet_adapter(this,itemList,getSupportFragmentManager()));
    }
}
