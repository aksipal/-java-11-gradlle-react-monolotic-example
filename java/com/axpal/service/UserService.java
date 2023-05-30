package com.axpal.service;

import com.axpal.dto.UserDto;
import com.axpal.dto.UserModel;
import com.axpal.exception.*;
import com.axpal.model.UserQueryModel;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.util.List;

@Validated
public interface UserService {


    UserModel userSave(@Valid UserModel model) throws SaveException, SingleRecordError;

    UserModel userUpdate(@Valid UserModel model) throws UpdateException;

    void userDelete(@NotNull @Positive Long id) throws DeleteException;

    List<UserModel> getUserList(@Valid UserQueryModel queryModel) throws GetException;

    UserModel getUser(@NotNull @Positive Long id) throws GetException, KontrolException;

}
