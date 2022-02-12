package com.example.Account.Service;


import com.example.Account.Model.Account_Model;
import com.example.Account.Repository.Account_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class Account_Service {

    @Autowired
    private Account_Repository account_repository;

    public Account_Model add(Account_Model acc){
        return account_repository.save(acc);
    }

    public List<Account_Model> findAll(){
        return (List<Account_Model>) account_repository.findAll();
    }


    public Account_Model findById(Integer acc_id){
        return account_repository.findById(acc_id).get();
    }
}
