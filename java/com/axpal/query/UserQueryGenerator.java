package com.axpal.query;

import com.axpal.dto.UserModel;
import com.axpal.entity.AxpalUserEntity;
import com.axpal.model.UserQueryModel;

import javax.persistence.PrePersist;

public class UserQueryGenerator  {

    private final AxpalUserEntity entity;

    private final UserQueryModel queryModel;
    public UserQueryGenerator(AxpalUserEntity entity, UserQueryModel queryModel) {
        this.entity = entity;
        this.queryModel = queryModel;
    }


    @PrePersist
    void getUser(UserModel model) {
        final String firsName = model.getUserFirstName();
        if (firsName == null || !firsName.matches("[a-z0-9]+")) {
            throw new IllegalArgumentException("Invalid username");
        }


    }
}