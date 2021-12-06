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
import com.prof.amine.myprof.adapters.ctxt_GS_adapter;
import com.prof.amine.myprof.models.ctxt_GS_item;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class CTxtGeneralSeanceFrag extends Fragment {

    private Button returnToSceDone;
    public CTxtGeneralSeanceFrag() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.activity_ctxt_general_seance, container, false);

        returnToSceDone=(Button)view.findViewById(R.id.btnReturnToSceDone);
        returnToSceDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment=null;
                fragment=new SeancesDoneFrag();
                if(fragment!=null) {
                    FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                    fragmentTransaction.replace(R.id.content_frame, fragment);
                    fragmentTransaction.commit();
                }
            }
        });

        //list of items
        List<ctxt_GS_item> itemList = new ArrayList<>();
        itemList.add(new ctxt_GS_item("N°33   16/05/2018"));
        itemList.add(new ctxt_GS_item("N°32   09/05/2018"));
        itemList.add(new ctxt_GS_item("N°31   02/05/2018"));

        //get listView
        ListView myListView=view.findViewById(R.id.list_view_ctxt_GS);
        myListView.setAdapter((ListAdapter) new ctxt_GS_adapter(getActivity(),itemList,getFragmentManager()));

        return view;
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getActivity().setTitle("حصة عامة : M06");

    }
}
