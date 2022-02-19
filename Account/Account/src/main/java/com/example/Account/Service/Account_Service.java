package com.example.Account.Service;


import com.example.Account.Enum.AccountType;
import com.example.Account.Model.Account_Model;
import com.example.Account.Model.PutRequest;
import com.example.Account.Repository.Account_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class Account_Service  {

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

    public List<Account_Model> findByCustid(Integer id){
        return (List<Account_Model>) account_repository.findByCustid(id);
    }


    public List<Account_Model> updateMoney(PutRequest p){
        List<Account_Model> acc= account_repository.findByCustid(p.getId());
        List<Account_Model> acc1= account_repository.findByCustid(p.getId());
        for(Account_Model accountModel : acc){
            if(accountModel.getAccountType().compareTo(p.getAcctype())==0){
                float b = accountModel.getAccount_balance();

                float sum = b+     (float) p.getMoney();



                accountModel.setAccount_balance(sum);
                account_repository.save(accountModel);

            }
            else
                acc1.remove(accountModel);

        }
        return acc1;


    }

    public List<Account_Model> updateActive(Integer id){
        List<Account_Model> acc = findByCustid(id);

        for(Account_Model i : acc){
            i.setIsactive(false);
            account_repository.save(i);
        }
        List<Account_Model> acc1 = findByCustid(id);
        return  acc1;

    }



}
