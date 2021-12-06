package com.prof.amine.myprof.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.prof.amine.myprof.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class AccueilFrag extends Fragment {


    public AccueilFrag() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.activity_accueil, container, false);
    }

}
