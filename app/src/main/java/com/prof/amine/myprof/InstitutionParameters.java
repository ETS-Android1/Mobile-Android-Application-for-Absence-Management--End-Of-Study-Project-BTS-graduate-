package com.prof.amine.myprof;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.prof.amine.myprof.adapters.instParam_adapter;
import com.prof.amine.myprof.models.instParam_item;

import java.util.ArrayList;
import java.util.List;

public class InstitutionParameters extends AppCompatActivity {
    private ImageButton returnToAcc;
    private Button bt1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_institution_parameters);

        returnToAcc=(ImageButton)findViewById(R.id.btnReturnToAcceuil);
        returnToAcc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toSplash = new Intent(getApplicationContext(),Accueil.class);
                startActivity(toSplash);
                finish();
            }
        });

       /* bt1=(Button)findViewById(R.id.btnIbnSina);
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toSplash = new Intent(getApplicationContext(),Institution.class);
                startActivity(toSplash);
                finish();
            }
        });*/

        //list of items
        List<instParam_item> itemList = new ArrayList<>();
        itemList.add(new instParam_item(1,"ثانوية إبن سينا"));
        itemList.add(new instParam_item(2,"ثانوية إبن بطوطة"));
        itemList.add(new instParam_item(3," ****ثانوية "));

        //get listView
        ListView myListView=findViewById(R.id.list_view_instParam);
        myListView.setAdapter((ListAdapter) new instParam_adapter(this,itemList,getSupportFragmentManager()));
    }
}
