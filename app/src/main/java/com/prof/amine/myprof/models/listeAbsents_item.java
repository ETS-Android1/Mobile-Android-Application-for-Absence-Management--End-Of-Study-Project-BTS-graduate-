package com.prof.amine.myprof.models;

public class listeAbsents_item {
    int idChk,idBtn,idImg;
    String nameBtn,nameImg;
    boolean checked;

    public listeAbsents_item(int idChk, int idBtn, int idImg, String nameBtn, String nameImg,boolean checked) {
        this.idChk = idChk;
        this.idBtn = idBtn;
        this.idImg = idImg;
        this.nameBtn = nameBtn;
        this.nameImg = nameImg;
        this.checked=checked;
    }

    public void setIdChk(int idChk) {
        this.idChk = idChk;
    }

    public void setIdBtn(int idBtn) {
        this.idBtn = idBtn;
    }

    public void setIdImg(int idImg) {
        this.idImg = idImg;
    }

    public void setNameBtn(String nameBtn) {
        this.nameBtn = nameBtn;
    }

    public void setNameImg(String nameImg) {
        this.nameImg = nameImg;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    public int getIdChk() {
        return idChk;
    }

    public int getIdBtn() {
        return idBtn;
    }

    public int getIdImg() {
        return idImg;
    }

    public String getNameBtn() {
        return nameBtn;
    }

    public String getNameImg() {
        return nameImg;
    }
}
