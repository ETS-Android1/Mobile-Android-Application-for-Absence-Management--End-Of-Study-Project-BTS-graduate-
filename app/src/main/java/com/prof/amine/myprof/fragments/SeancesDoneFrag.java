package com.prof.amine.myprof.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.prof.amine.myprof.R;
import com.prof.amine.myprof.adapters.seanDone_adapter;
import com.prof.amine.myprof.models.seanDone_item;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class SeancesDoneFrag extends Fragment {


    public SeancesDoneFrag() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.activity_seances_done, container, false);

        //list of items
        List<seanDone_item> itemList = new ArrayList<>();
        itemList.add(new seanDone_item(33,"N°33   16/05/2018"));
        itemList.add(new seanDone_item(32,"N°32   09/05/2018"));
        itemList.add(new seanDone_item(31,"N°31   02/05/2018"));

        //get listView
        ListView myListView=view.findViewById(R.id.list_view_seancesDone);
        myListView.setAdapter((ListAdapter) new seanDone_adapter(getActivity(),itemList,getFragmentManager()));

        return view;
    }

}
