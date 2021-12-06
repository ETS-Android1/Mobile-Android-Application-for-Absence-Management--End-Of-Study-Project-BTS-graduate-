package com.prof.amine.myprof.fragments;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.prof.amine.myprof.R;
import com.prof.amine.myprof.adapters.instParam_adapter;
import com.prof.amine.myprof.models.instParam_item;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class InstitutionParametersFrag extends Fragment {


    public InstitutionParametersFrag() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.activity_institution_parameters, container, false);

        //list of items
        List<instParam_item> itemList = new ArrayList<>();
        itemList.add(new instParam_item(1,"ثانوية إبن سينا"));
        itemList.add(new instParam_item(2,"ثانوية إبن بطوطة"));
        itemList.add(new instParam_item(3," ****ثانوية "));

        //get listView
        ListView myListView=view.findViewById(R.id.list_view_instParam);
        myListView.setAdapter((ListAdapter) new instParam_adapter(getActivity(),itemList,getFragmentManager()));

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getActivity().setTitle("إعدادات المؤسسة");

    }

}
