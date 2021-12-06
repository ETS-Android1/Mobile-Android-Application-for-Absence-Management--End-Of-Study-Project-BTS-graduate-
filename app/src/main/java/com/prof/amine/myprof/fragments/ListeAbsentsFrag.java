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
import android.widget.CheckBox;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.prof.amine.myprof.R;
import com.prof.amine.myprof.adapters.listeAbsents_adapter;
import com.prof.amine.myprof.models.listeAbsents_item;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONArray;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.logging.Logger.global;

/**
 * A simple {@link Fragment} subclass.
 */
public class ListeAbsentsFrag extends Fragment {
    private Button confirmAbs;


    public ListeAbsentsFrag() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.activity_liste_absents, container, false);
        final ListView myListView=view.findViewById(R.id.list_view_listeAbsents);
        confirmAbs=(Button)view.findViewById(R.id.BtnConfirmAbs);
        final List<listeAbsents_item> itemList = new ArrayList<>();
        final RequestQueue requestQueue= Volley.newRequestQueue(getActivity().getApplicationContext());

        //list of items
        String showAbs="http://192.168.1.166/php/selection.php";

        final listeAbsents_adapter[] adapter = new listeAbsents_adapter[1];
        JsonObjectRequest jsonObjectRequest=new JsonObjectRequest(Request.Method.POST, showAbs, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                try {
                    JSONArray absences=response.getJSONArray("Absence");
                    for(int i=0;i<absences.length();i++){
                        JSONObject absence=absences.getJSONObject(i);
                        String nom=absence.getString("nomEtPrenom");
                        System.out.println("salam "+nom);
                        String img=absence.getString("img");
                        boolean isabsence=absence.getBoolean("isAbsence");
                        listeAbsents_item l= new listeAbsents_item(1,1,1,nom,img,isabsence);
                        itemList.add(l);

                    }
                    adapter[0] =new listeAbsents_adapter(getActivity(),itemList,getFragmentManager());
                    myListView.setAdapter(adapter[0]);

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
            }
        });
requestQueue.add(jsonObjectRequest);



        //itemList.add(new listeAbsents_item(2,2,2,"محسن أنونيم","personnel"));
        //itemList.add(new listeAbsents_item(3,3,3," xxxxxxxxxxxxx ","personnel"));

        confirmAbs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {/*
                Cluster cluster = CouchbaseCluster.create("kali");
                cluster.authenticate("Administrator", "ioioio");
                Bucket bucket = cluster.openBucket("default");


                    //System.out.println("voila");

                    for(int j=0;j<adapter.getAllAbs().size();j++) {
                        JsonObject eleve = JsonObject.create()
                                .put("name", adapter.getAllAbs().get(j).getNomEtPrenom())
                                .put("image", adapter.getAllAbs().get(j).getImg())
                                .put("absence",adapter.selectedStrings[j]);
                        bucket.upsert(JsonDocument.create("u:eleveNumero"+j, eleve));
                    }

                Connection cn;
                try{
                    try {
                        Class.forName("com.mysql.jdbc.Driver").newInstance();
                    }catch (ClassNotFoundException E){E.printStackTrace();

                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    } catch (java.lang.InstantiationException e) {
                        e.printStackTrace();
                    }


                    cn= DriverManager.getConnection("jdbc:mysql://localhost/pfe","root","");

                    Statement statement=cn.createStatement();


                }catch (SQLException e){e.printStackTrace();}


                */


                String insertUrl="http://192.168.1.166/php/insert.php";
                StringRequest stringRequest=new StringRequest(Request.Method.POST, insertUrl, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                }){
                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {
                        HashMap<String,String> parameters=new HashMap<>();
                        for(int i = 0; i< adapter[0].getAllAbs().size(); i++) {
                            parameters.put("name"+i, adapter[0].getAllAbs().get(i).getNomEtPrenom());
                            parameters.put("image"+i, adapter[0].getAllAbs().get(i).getImg());
                            parameters.put("isabsence"+i, String.valueOf(adapter[0].selectedStrings[i]));
                        }

                        parameters.put("countt",String.valueOf(adapter[0].getAllAbs().size()));
                        return parameters;
                    }
                };

                requestQueue.add(stringRequest);






                Fragment fragment=null;
                fragment=new SeanceFrag();
                if(fragment!=null) {
                    FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                    fragmentTransaction.replace(R.id.content_frame, fragment);
                    fragmentTransaction.commit();
                }
            }
        });



        //get listView

        myListView.setAdapter(adapter[0]);



        return view;
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getActivity().setTitle("الغائبون في الحصة رقم: ...");

    }
}
