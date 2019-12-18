package com.example.demo.services;
import  com.example.demo.dao.*;
import  com.example.demo.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service

public class UserServices {

    private userDaoInterface udi;

    @Autowired
    public UserServices( @Qualifier("userDao") userDaoInterface udi) {
        this.udi = udi;
    }

    public int AddUser(user U){

    return    udi.insertUser(U);

    }
    public List<user> SelectUsers(){


        return udi.SelectALL();

    }
    public user selectbyId(UUID id){

        return udi.SelectByID(id).get();
    }
    public  int deleteByID( UUID id){

        return  udi.DeleteUser(id);
    }

    public  int UpdateByid(UUID id,user u){


        return udi.Update(id,u);
    }



}
