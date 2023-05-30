package com.axpal.entity;

import lombok.Data;

import javax.persistence.Column;

@Data
public class AxpalUserEntity extends AxpalEntity{

    @Column(name = "USER_FIRST_NAME")
    private String userFirstName;


    @Column(name = "USER_lAST_NAME")
    private String userLastName;
    
    public String getUserFirstName() {
        return userFirstName;
    }

    public void setUserFirstName(String userFirstName) {
        this.userFirstName = userFirstName;
    }

    public String getUserLastName() {
        return userLastName;
    }

    public void setUserLastName(String userLastName) {
        this.userLastName = userLastName;
    }





    @Override
    public String getUuid() {
        return null;
    }

    @Override
    public void setUuid(String uuid) {

    }
}
