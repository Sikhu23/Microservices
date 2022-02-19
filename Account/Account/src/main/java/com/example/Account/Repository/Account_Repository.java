package com.example.Account.Repository;

import com.example.Account.Model.Account_Model;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface Account_Repository extends CrudRepository<Account_Model,Integer> {



    public default float addMoney(float money){

        return money;



    }

    List<Account_Model> findByCustid(Integer id);
}
