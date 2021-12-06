package com.prof.amine.myprof.fragments;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;

import com.prof.amine.myprof.R;
import com.prof.amine.myprof.models.gs_item;

import java.util.List;

public class gs_adapterArray extends ArrayAdapter<gs_item> {

    public FragmentManager fragmentManager;
    private List<gs_item> itemList;

    public gs_adapterArray(@NonNull Context context, List<gs_item> resource, FragmentManager fragmentManager) {
        super(context, R.layout.adapter_general_seance,resource);
        this.fragmentManager=fragmentManager;
        this.itemList=resource;
    }

    @SuppressLint("ResourceType")
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater=LayoutInflater.from(getContext());
        View customview =layoutInflater.inflate(R.layout.adapter_general_seance,parent,false);

        //get information about item
        gs_item currentItem = itemList.get(position);
        final String itemName = currentItem.getName();
        final int itemId = currentItem.getId();

        //get item name button
        Button itemNameButton = convertView.findViewById(R.id.btnGSeance);
        itemNameButton.setText(itemName);
        itemNameButton.setId(itemId);

       /* final gs_item list=getItem(position);
        Button button=(Button) customview.findViewById(R.id.button_jadwal);
        button.setText(list);*/


        if(itemNameButton.getId()==33)
            itemNameButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Fragment fragment=null;
                    fragment=new SeanceFrag();
                    if(fragment!=null){
                        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
                        fragmentTransaction.replace(R.id.content_frame,fragment);
                        fragmentTransaction.commit(); }
                }
            });

        return customview;
    }
}
