package com.example.demo.apirest;

import com.example.demo.services.UserServices;
import  com.example.demo.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequestMapping("api/user")
@RestController
public class UserContoller {

    private UserServices  US;

    @Autowired
    public UserContoller( UserServices US) {
        this.US = US;
    }

   @PostMapping
    public void addUser( @RequestBody user u){


         US.AddUser(u);
    }

    @GetMapping
    public List<user> GetAllUser(){


        return US.SelectUsers();

    }
    @GetMapping(path = "{id}")
    public user getById(@PathVariable("id") UUID id){

        return  US.selectbyId(id);
    }
    @DeleteMapping(path = "{id}")

    public  boolean DeleteById( @PathVariable("id") UUID id){

        if ( US.deleteByID(id) == 1){

            return true;
        }else{
            return false;
        }
    }
     @PutMapping(path="{id}")
    public  boolean UpdateUser( @PathVariable("id") UUID id ,@RequestBody user u){


        if ( US.UpdateByid(id,u) == 1){

            return true;
        }else{
            return false;
        }


    }
}
