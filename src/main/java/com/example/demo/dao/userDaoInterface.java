package com.example.demo.dao;

import com.example.demo.model.user;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface userDaoInterface {


    int insertUser(UUID id, user User);

    default int insertUser(user User){

        UUID id= UUID.randomUUID();


        return insertUser(id,User);

    }


    List<user> SelectALL();
    Optional<user> SelectByID(UUID id);
    int DeleteUser(UUID id);
    int Update(UUID id ,user user);





}
