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
import com.prof.amine.myprof.adapters.novDet_adapter;
import com.prof.amine.myprof.models.novDet_item;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class NoveltyDetailsFrag extends Fragment {
    private Button updateNovDet,addComment,closeNov;

    public NoveltyDetailsFrag() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.activity_novelty_details, container, false);

        updateNovDet=(Button)view.findViewById(R.id.BtnUpdateNovDet);
        updateNovDet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment=null;
                fragment=new Update_noveltyFrag();
                if(fragment!=null) {
                    FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                    fragmentTransaction.replace(R.id.content_frame, fragment);
                    fragmentTransaction.commit();
                }
            }
        });

        addComment=(Button)view.findViewById(R.id.BtnAddComment);
        addComment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment=null;
                fragment=new CommentFrag();
                if(fragment!=null) {
                    FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                    fragmentTransaction.replace(R.id.content_frame, fragment);
                    fragmentTransaction.commit();
                }
            }
        });

        closeNov=(Button)view.findViewById(R.id.BtnCloseNov);
        closeNov.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment=null;
                fragment=new NoveltiesFrag();
                if(fragment!=null) {
                    FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                    fragmentTransaction.replace(R.id.content_frame, fragment);
                    fragmentTransaction.commit();
                }
            }
        });

        //list of items
        List<novDet_item> itemList = new ArrayList<>();
        itemList.add(new novDet_item(1,1,"Est-ce que la documentation est autorisée ?","محمد أمين مخايبو"));
        itemList.add(new novDet_item(2,2,"xxxxxxxxxxxxx","xxxxxxxxxxxxx"));
        itemList.add(new novDet_item(3,3," xxxxxxxxxxxxx ","xxxxxxxxxxxxx"));

        //get listView
        ListView myListView=view.findViewById(R.id.list_view_noveltyDetails);
        myListView.setAdapter((ListAdapter) new novDet_adapter(getActivity(),itemList,getFragmentManager()));

        return view;
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getActivity().setTitle("تفاصيل المستجد");

    }
}
