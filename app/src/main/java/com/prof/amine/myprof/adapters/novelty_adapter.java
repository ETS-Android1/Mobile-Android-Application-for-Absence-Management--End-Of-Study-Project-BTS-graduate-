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

import com.prof.amine.myprof.NoveltyDetails;
import com.prof.amine.myprof.R;
import com.prof.amine.myprof.fragments.AccountFrag;
import com.prof.amine.myprof.fragments.InstitutionFrag;
import com.prof.amine.myprof.fragments.NoveltyDetailsFrag;
import com.prof.amine.myprof.models.novelty_item;

import java.util.List;

public class novelty_adapter extends ArrayAdapter<novelty_item> {
    private Context context;
    private List<novelty_item> itemList;

    public FragmentManager fragmentManager;
    //constructor
    public novelty_adapter(Context context, List<novelty_item> itemList,FragmentManager fragmentManager){
        super(context,R.layout.adapter_novelties,itemList);
        this.context = context;
        this.itemList = itemList;

        this.fragmentManager=fragmentManager;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater=LayoutInflater.from(getContext());

        convertView = layoutInflater.inflate(R.layout.adapter_novelties,parent,false);
        //get information about item
        novelty_item currentItem = itemList.get(position);
        final String itemName = currentItem.getName();
        final int itemId = currentItem.getId();

        //get item name button
        Button itemNameButton = convertView.findViewById(R.id.btnNovelties);
        itemNameButton.setText(itemName);
        itemNameButton.setId(itemId);

            itemNameButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    /*
                    Intent toSplash = new Intent(context.getApplicationContext(), NoveltyDetails.class);
                    context.startActivity(toSplash);
              */
                    Fragment fragment=null;
                    fragment=new NoveltyDetailsFrag();
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
