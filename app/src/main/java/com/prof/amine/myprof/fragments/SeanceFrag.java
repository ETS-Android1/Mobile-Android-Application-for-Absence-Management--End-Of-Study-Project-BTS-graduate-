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
import android.widget.TextView;

import com.prof.amine.myprof.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * A simple {@link Fragment} subclass.
 */
public class SeanceFrag extends Fragment {
    private Button absents,saveSeance;
    private TextView dateSeance;

    public SeanceFrag() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.activity_seance, container, false);

        absents=(Button)view.findViewById(R.id.BtnAbsents);
        absents.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment=null;


                fragment=new ListeAbsentsFrag();
                if(fragment!=null) {
                    FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                    fragmentTransaction.replace(R.id.content_frame, fragment);
                    fragmentTransaction.commit();
                }
            }
        });

        saveSeance=(Button)view.findViewById(R.id.BtnSaveSeance);
        saveSeance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment=null;
                fragment=new GeneralSeanceFrag();
                if(fragment!=null) {
                    FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                    fragmentTransaction.replace(R.id.content_frame, fragment);
                    fragmentTransaction.commit();
                }
            }
        });

        Calendar c = Calendar.getInstance();
        SimpleDateFormat dateformat = new SimpleDateFormat("dd/MM/yyyy");
        String myDate = dateformat.format(c.getTime());
        dateSeance=(TextView)view.findViewById(R.id.lblDate);
        dateSeance.setText(myDate);

        return view;
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getActivity().setTitle("حصة رقم: ...");

    }

}
