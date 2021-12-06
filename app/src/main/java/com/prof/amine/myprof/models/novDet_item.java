package com.prof.amine.myprof.models;

public class novDet_item {
    int idLbl,idBtn;
    String nameLbl,nameBtn;

    public novDet_item(int idLbl, int idBtn, String nameLbl, String nameBtn) {
        this.idLbl = idLbl;
        this.idBtn = idBtn;
        this.nameLbl = nameLbl;
        this.nameBtn = nameBtn;
    }

    public int getIdLbl() {
        return idLbl;
    }

    public int getIdBtn() {
        return idBtn;
    }

    public String getNameLbl() {
        return nameLbl;
    }

    public String getNameBtn() {
        return nameBtn;
    }
}
