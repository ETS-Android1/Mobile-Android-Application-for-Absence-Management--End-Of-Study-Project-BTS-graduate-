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

import com.prof.amine.myprof.CTxtGeneralSeance;
import com.prof.amine.myprof.R;
import com.prof.amine.myprof.fragments.CTxtGeneralSeanceFrag;
import com.prof.amine.myprof.fragments.NoveltyDetailsFrag;
import com.prof.amine.myprof.models.seanDone_item;

import java.util.List;

public class seanDone_adapter extends ArrayAdapter<seanDone_item>{
    private Context context;
    private List<seanDone_item> itemList;
    FragmentManager fragmentManager;

    //constructor
    public seanDone_adapter(Context context, List<seanDone_item> itemList,FragmentManager fragmentManager) {
        super(context,R.layout.adapter_seances_done,itemList);
        this.context = context;
        this.itemList = itemList;
        this.fragmentManager=fragmentManager;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater=LayoutInflater.from(getContext());
        convertView = layoutInflater.inflate(R.layout.adapter_seances_done,parent,false);
        //get information about item
        seanDone_item currentItem = itemList.get(position);
        final String itemName = currentItem.getName();
        final int itemId = currentItem.getId();

        //get item name button
        Button itemNameButton = convertView.findViewById(R.id.btnSeanceDone);
        itemNameButton.setText(itemName);
        itemNameButton.setId(itemId);


            itemNameButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    /*
                    Intent toSplash = new Intent(context.getApplicationContext(), CTxtGeneralSeance.class);
                    context.startActivity(toSplash);
*/

                    Fragment fragment=null;
                    fragment=new CTxtGeneralSeanceFrag();
                    FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.content_frame,fragment);
                    fragmentTransaction.commit();

                }
            });
       /* else if(itemNameButton.getId()==2)
            itemNameButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent toSplash = new Intent(context.getApplicationContext(), Institution.class);
                    context.startActivity(toSplash);
                }
            });*/

        return convertView;
    }
}
