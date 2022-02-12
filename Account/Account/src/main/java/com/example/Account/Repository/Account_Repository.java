package com.example.Account.Repository;

import com.example.Account.Model.Account_Model;
import org.springframework.data.repository.CrudRepository;

public interface Account_Repository extends CrudRepository<Account_Model,Integer> {

}
