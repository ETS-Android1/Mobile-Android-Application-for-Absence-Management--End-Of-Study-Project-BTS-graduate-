package com.prof.amine.myprof.adapters;

import android.content.Context;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.prof.amine.myprof.R;
import com.prof.amine.myprof.models.ctxt_GS_item;

import java.util.List;

public class ctxt_GS_adapter extends ArrayAdapter<ctxt_GS_item> {

    private Context context;
    private List<ctxt_GS_item> itemList;
    public FragmentManager fragmentManager;

    //constructor
    public ctxt_GS_adapter(Context context, List<ctxt_GS_item> itemList,FragmentManager fragmentManager) {
        super(context,R.layout.adapter_ctxt_general_seance,itemList);
        this.context = context;
        this.itemList = itemList;
        this.fragmentManager=fragmentManager;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater=LayoutInflater.from(getContext());

        convertView = layoutInflater.inflate(R.layout.adapter_ctxt_general_seance,parent,false);
        //get information about item
        ctxt_GS_item currentItem = itemList.get(position);
        final String itemName = currentItem.getName();

        //get item name view
        TextView itemNameView = convertView.findViewById(R.id.txtCtxtGSeance);
        itemNameView.setText(itemName);

        return convertView;
    }
}
