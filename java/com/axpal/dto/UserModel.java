package com.axpal.dto;

import com.axpal.model.AxpalModel;
import lombok.Data;

import javax.persistence.Column;
@Data
public class UserModel extends AxpalModel {


    private String userFirstName;

    private String userLastName;


}
