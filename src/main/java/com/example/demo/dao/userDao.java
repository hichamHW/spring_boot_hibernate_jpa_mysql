package com.example.demo.dao;
import  com.example.demo.model.*;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("userDao")
@Transactional

public class userDao implements   userDaoInterface  {
   /// private static List<user> DB = new ArrayList<user>();



    @PersistenceContext
    EntityManager em ;



    @Override
    public int insertUser(UUID id, user User) {


        ///DB.add(new user(id,User.getName(),User.getDepratement()));

        em.getTransaction().begin();


        ////begin traitement
        em.persist(new user(id,User.getName(),User.getDepratement()));

        ////fin traitement


        em.getTransaction().commit();
        return 1;
    }

   public List<user>SelectALL(){

       em.getTransaction().begin();


       ////begin traitement
       List<user> users =em.createQuery("SELECT a FROM user a", user.class).getResultList();
       ////fin traitement


       em.getTransaction().commit();
       return users;

   }

    @Override
    public Optional<user> SelectByID(UUID id) {
        em.getTransaction().begin();


        ////begin traitement
        List<user> users =em.createQuery("SELECT a FROM user a", user.class).getResultList();
        ////fin traitement


        em.getTransaction().commit();


        return users.stream().filter(user -> user.getId().equals(id)).findFirst();

    }

    @Override
    public int DeleteUser(UUID id) {

        user u = SelectByID(id).get();
        if(u == null){
            return 0;
        }else{

            em.getTransaction().begin();



            em.remove(u);
            em.getTransaction().commit();


            return 1;
        }
    }

    @Override
    public int Update(UUID id, user user) {

        if(DeleteUser(id) ==1){

            insertUser(id,user);

            return 1;
        }else{

            return 0;

        }




    }


}
