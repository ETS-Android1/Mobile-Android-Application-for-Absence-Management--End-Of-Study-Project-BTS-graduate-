package com.prof.amine.myprof.models;

import android.media.Image;

public class AbsenceObject {

    private String NomEtPrenom;

    private String Img;

    public AbsenceObject(String nomEtPrenom, String img) {
        NomEtPrenom = nomEtPrenom;

        Img = img;
    }

    public String getNomEtPrenom() {
        return NomEtPrenom;
    }



    public String getImg() {
        return Img;
    }

    public void setNomEtPrenom(String nomEtPrenom) {
        NomEtPrenom = nomEtPrenom;
    }


    public void setImg(String img) {
        Img = img;
    }
}
