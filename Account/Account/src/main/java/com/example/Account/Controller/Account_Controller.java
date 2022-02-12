package com.example.Account.Controller;


import com.example.Account.Model.Account_Model;
import com.example.Account.Service.Account_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/account")
public class Account_Controller {


    @Autowired
    private Account_Service account_service;



    @PostMapping
    public ResponseEntity<Account_Model> save(@RequestBody Account_Model cus){
        return new ResponseEntity<Account_Model>(account_service.add(cus), HttpStatus.CREATED);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity <Account_Model> findById(@PathVariable("id") Integer cust_id){
        return new ResponseEntity<Account_Model>(account_service.findById(cust_id),HttpStatus.ACCEPTED);
    }



    @GetMapping()
    public ResponseEntity <List<Account_Model>> findAll(){
        return new ResponseEntity<List<Account_Model>>(account_service.findAll(),HttpStatus.ACCEPTED);
    }
}
