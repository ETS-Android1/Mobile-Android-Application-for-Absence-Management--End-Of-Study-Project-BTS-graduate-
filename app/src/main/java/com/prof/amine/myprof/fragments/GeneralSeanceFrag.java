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
import com.prof.amine.myprof.adapters.gs_adapter;
import com.prof.amine.myprof.models.gs_item;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class GeneralSeanceFrag extends Fragment {
    private Button newSeance;

    public GeneralSeanceFrag() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.activity_general_seance, container, false);

        newSeance=(Button)view.findViewById(R.id.BtnNewSeance);
        newSeance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment=null;
                fragment=new SeanceFrag();
                if(fragment!=null) {
                    FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                    fragmentTransaction.replace(R.id.content_frame, fragment);
                    fragmentTransaction.commit();
                }
            }
        });
        //list of items
        List<gs_item> itemList = new ArrayList<>();
        itemList.add(new gs_item(33,"N°33   16/05/2018"));
        itemList.add(new gs_item(32,"N°32   09/05/2018"));
        itemList.add(new gs_item(31,"N°31   02/05/2018"));

        //get listView
        ListView myListView=view.findViewById(R.id.list_view_GS);
        myListView.setAdapter((ListAdapter) new gs_adapter(getActivity(),itemList,getFragmentManager()));


        /*ListView listview=(ListView)view.findViewById(R.id.list_view_GS);
        ListAdapter adapter=new gs_adapterArray(getActivity(),itemList,getFragmentManager());
        listview.setAdapter(adapter);*/

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getActivity().setTitle("حصة عامة : M06");

    }

   /* fragment
   public void goToSeance(int idButton){

            if(idButton==33){
                        try {
                        Fragment fragment=null;
                        fragment=new SeanceFrag();
                        if(fragment!=null) {

                            FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                            fragmentTransaction.replace(R.id.content_frame, fragment);
                            fragmentTransaction.commit();
                        }
                }catch (Exception ex) {
                    System.err.println("erreur "+ex);
                }
                    }

    }*/
}
