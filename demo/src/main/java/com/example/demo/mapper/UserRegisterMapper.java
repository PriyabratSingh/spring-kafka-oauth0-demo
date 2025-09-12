package com.example.demo.mapper;

import com.example.demo.entity.UserRegister;
import org.springframework.stereotype.Component;

@Component
public class UserRegisterMapper {


    public UserRegister giveMeUserEntity(com.example.demo.model.UserRegister register){
        UserRegister userRegister = new UserRegister();
        //userRegister.setId(register.getId());
        userRegister.setName(register.getName());
        return userRegister;
    }


}
