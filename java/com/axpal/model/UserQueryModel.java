package com.axpal.model;

import com.axpal.model.query.AxpalQueryModel;

public class UserQueryModel extends AxpalQueryModel {

    private Integer ilacFiyat;

    public Integer getIlacFiyat() {
        return ilacFiyat;
    }

    public void setIlacFiyat(Integer ilacFiyat) {
        this.ilacFiyat = ilacFiyat;
    }
}
