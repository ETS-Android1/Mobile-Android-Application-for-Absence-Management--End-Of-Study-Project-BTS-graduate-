package com.prof.amine.myprof.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;

import com.prof.amine.myprof.R;
import com.prof.amine.myprof.fragments.AccountFrag;
import com.prof.amine.myprof.fragments.InstitutionFrag;
import com.prof.amine.myprof.models.instParam_item;

import java.util.List;

public class instParam_adapter extends ArrayAdapter<instParam_item> {
    private Context context;
    public FragmentManager fragmentManager;
    public instParam_adapter(@NonNull Context context, List<instParam_item> resource, FragmentManager fragmentManager) {
        super(context,R.layout.adapter_institution_parameters,resource);
        this.fragmentManager=fragmentManager;
        this.context=context;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater=LayoutInflater.from(getContext());
        convertView = layoutInflater.inflate(R.layout.adapter_institution_parameters,parent,false);
        //get information about item

        instParam_item item=super.getItem(position);

                //get item name button
        Button itemNameButton = convertView.findViewById(R.id.btnInstiParam);
        itemNameButton.setText(item.getName());

            itemNameButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    /*
                    Intent toSplash = new Intent(context.getApplicationContext(), Institution.class);
                    context.startActivity(toSplash);
                */

                    Fragment fragment=null;
                    fragment=new InstitutionFrag();
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
