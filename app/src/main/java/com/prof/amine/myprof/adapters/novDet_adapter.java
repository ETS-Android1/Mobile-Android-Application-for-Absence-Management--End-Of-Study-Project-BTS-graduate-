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
import android.widget.TextView;

import com.prof.amine.myprof.CommentatorProfil;
import com.prof.amine.myprof.R;
import com.prof.amine.myprof.fragments.CommentatorProfilFrag;
import com.prof.amine.myprof.fragments.StudentProfilFrag;
import com.prof.amine.myprof.models.novDet_item;

import java.util.List;

public class novDet_adapter extends ArrayAdapter<novDet_item> {
    private Context context;
    private List<novDet_item> itemList;
    private LayoutInflater infleter;
    FragmentManager fragmentManager;
    //constructor
    public novDet_adapter(Context context, List<novDet_item> itemList,FragmentManager fragmentManager) {
        super(context,R.layout.adapter_novelty_details,itemList);
        this.context = context;
        this.itemList = itemList;
        this.fragmentManager=fragmentManager;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater layoutInflater=LayoutInflater.from(getContext());
        convertView = layoutInflater.inflate(R.layout.adapter_novelty_details,parent,false);
        //get information about item
        novDet_item currentItem = itemList.get(position);
        final String itemNameLbl = currentItem.getNameLbl();
        final int itemIdLbl = currentItem.getIdLbl();
        final String itemNameBtn = currentItem.getNameBtn();
        final int itemIdBtn = currentItem.getIdBtn();

        //get item name,id TextView
        TextView itemNameTxtView = convertView.findViewById(R.id.lblCommNov);
        itemNameTxtView.setText(itemNameLbl);
        itemNameTxtView.setId(itemIdLbl);
        //get item name,id button
        Button itemNameButton = convertView.findViewById(R.id.btnCommPer);
        itemNameButton.setText(itemNameBtn);
        itemNameButton.setId(itemIdBtn);


            itemNameButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    /*
                    Intent toSplash = new Intent(context.getApplicationContext(), CommentatorProfil.class);
                    context.startActivity(toSplash);
                */
                    Fragment fragment=null;
                    fragment=new CommentatorProfilFrag();
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
