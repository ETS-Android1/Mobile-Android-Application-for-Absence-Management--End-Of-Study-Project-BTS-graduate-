package com.prof.amine.myprof.fragments;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.prof.amine.myprof.R;
import com.prof.amine.myprof.adapters.novelty_adapter;
import com.prof.amine.myprof.models.novelty_item;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class NoveltiesFrag extends Fragment {
    private Button newNovelty;

    public NoveltiesFrag() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.activity_novelties, container, false);

        newNovelty=(Button)view.findViewById(R.id.BtnNewNovelty);
        newNovelty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment=null;
                fragment=new NewNoveltyFrag();
                if(fragment!=null) {
                    FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                    fragmentTransaction.replace(R.id.content_frame, fragment);
                    fragmentTransaction.commit();
                }
            }
        });
        //list of items
        List<novelty_item> itemList = new ArrayList<>();
        itemList.add(new novelty_item(1,"فرض محروس في مادةTransact SQL بتاريخ:02/05/2018؛مشاركة:ذ.حميد"));
        itemList.add(new novelty_item(2,"الأستاذ*جمال أقبلي* في رخصة مرضية من 12/02/2018 إلى 15/02/2018؛مشاركة:الإدارة"));
        itemList.add(new novelty_item(3," ******** "));

        //get listView
        ListView myListView=view.findViewById(R.id.list_view_novelties);
        myListView.setAdapter((ListAdapter) new novelty_adapter(getActivity(),itemList,getFragmentManager()));

        return view;
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getActivity().setTitle("مستجدات");

    }

}
