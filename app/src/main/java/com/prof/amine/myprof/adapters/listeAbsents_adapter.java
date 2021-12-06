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
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.TextView;

import com.prof.amine.myprof.StudentProfil;
import com.prof.amine.myprof.R;
import com.prof.amine.myprof.fragments.InstitutionFrag;
import com.prof.amine.myprof.fragments.StudentProfilFrag;
import com.prof.amine.myprof.models.AbsenceObject;
import com.prof.amine.myprof.models.listeAbsents_item;

import java.util.ArrayList;
import java.util.List;

public class listeAbsents_adapter extends ArrayAdapter<listeAbsents_item> {
    private Context context;
    final public boolean[] selectedStrings = new boolean[getCount()];
     public ArrayList<AbsenceObject> AllAbs=new ArrayList<>();


    private List<listeAbsents_item> itemList;
    FragmentManager fragmentManager;

    //constructor
    public listeAbsents_adapter(Context context, List<listeAbsents_item> itemList,FragmentManager fragmentManager) {
        super(context,R.layout.adapter_institution_parameters,itemList);
        this.fragmentManager=fragmentManager;
        this.context=context;

    }
    public ArrayList<AbsenceObject> getAllAbs(){return AllAbs;}


    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        LayoutInflater layoutInflater=LayoutInflater.from(getContext());
        convertView = layoutInflater.inflate(R.layout.adapter_liste_absents,parent,false);
        //get information about item
        listeAbsents_item currentItem = getItem(position);
        final int itemIdChk = currentItem.getIdChk();
        final int itemIdBtn = currentItem.getIdBtn();
        final String itemNameBtn = currentItem.getNameBtn();
        final int itemIdImg = currentItem.getIdImg();
        System.out.println("salamo3alykom"+getItem(position).getNameBtn());
        final String itemNameImg = currentItem.getNameImg();

        //set item id CheckBox
        final CheckBox itemNameTxtView = convertView.findViewById(R.id.checkboxAbsent);
        itemNameTxtView.setChecked(getItem(position).isChecked());
        /*
        AllAbs[position].setNomEtPrenom(itemNameBtn);
        AllAbs[position].setImg(itemNameImg);*/
        AllAbs.add(new AbsenceObject(itemNameBtn,itemNameImg));


        itemNameTxtView.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
               /* if (isChecked) {
                    selectedStrings.add(itemNameTxtView.getText().toString());
                    System.out.println("dfdfd");
                }else{
                    selectedStrings.remove(itemNameTxtView.getText().toString());
                }
                */
                if (isChecked) {
                    selectedStrings[position]=true;

                }else{


                    selectedStrings[position]=false;

                }

            }
        });
        itemNameTxtView.setId(itemIdChk);
        //set item name,id button
        Button itemNameButton = convertView.findViewById(R.id.btnNomPrenomAbsent);
        itemNameButton.setText(itemNameBtn);
        itemNameButton.setId(itemIdBtn);
        //set item name,id imgButton
        ImageButton itemNameImgButton = convertView.findViewById(R.id.btnImgAbsent);
        itemNameImgButton.setId(itemIdImg);
        int resId=context.getResources().getIdentifier(itemNameImg,"drawable",context.getPackageName());
        itemNameImgButton.setImageResource(resId);

            itemNameButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    /*
                    Intent toSplash = new Intent(context.getApplicationContext(), StudentProfil.class);
                    context.startActivity(toSplash);
                */
                    Fragment fragment=null;
                    fragment=new StudentProfilFrag();
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
    boolean[] getCheckedValue(){

        return selectedStrings;}
}
