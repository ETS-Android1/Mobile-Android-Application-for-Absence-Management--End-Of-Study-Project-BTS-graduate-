package com.prof.amine.myprof.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;

import com.prof.amine.myprof.R;
import com.prof.amine.myprof.fragments.InstitutionFrag;
import com.prof.amine.myprof.fragments.SeanceFrag;
import com.prof.amine.myprof.models.gs_item;
import com.prof.amine.myprof.Seance;

import java.lang.reflect.Array;
import java.util.List;

public class gs_adapter extends ArrayAdapter<gs_item> {
    private Context context;
    private List<gs_item> itemList;
    private LayoutInflater infleter;
    FragmentManager fragmentManager;
    //constructor
    public gs_adapter(Context context, List<gs_item> itemList, FragmentManager fragmentManager) {
        super(context,R.layout.adapter_general_seance,itemList);
        this.context = context;
        this.itemList = itemList;
        this.infleter = LayoutInflater.from(context);
        this.fragmentManager=fragmentManager;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater=LayoutInflater.from(getContext());
        convertView = layoutInflater.inflate(R.layout.adapter_general_seance,parent,false);
        //get information about item
        gs_item currentItem = itemList.get(position);
        final String itemName = currentItem.getName();
        final int itemId = currentItem.getId();

        //get item name button
        Button itemNameButton = convertView.findViewById(R.id.btnGSeance);
        itemNameButton.setText(itemName);
        itemNameButton.setId(itemId);


            itemNameButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //GeneralSeanceFrag gsFrag=new GeneralSeanceFrag();
                //gsFrag.goToSeance(33);
               // Intent toSplash = new Intent(context.getApplicationContext(), Seance.class);
              // context.startActivity(toSplash);
                Fragment fragment=null;
                fragment=new SeanceFrag();
                FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.content_frame,fragment);
                fragmentTransaction.commit();
            }
        });

        /*else if(itemNameButton.getId()==32)
            itemNameButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent toSplash = new Intent(context.getApplicationContext(), Account.class);
                    context.startActivity(toSplash);
                }
            });*/
        return convertView;
    }
}
