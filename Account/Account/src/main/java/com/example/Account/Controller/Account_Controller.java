package com.example.Account.Controller;


import com.example.Account.Enum.AccountType;
import com.example.Account.Model.Account_Model;
import com.example.Account.Model.PutRequest;
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
    public ResponseEntity <List<Account_Model> >findById(@PathVariable("id") Integer cust_id){
        return new ResponseEntity<List<Account_Model>>((List<Account_Model>) account_service.findById(cust_id),HttpStatus.ACCEPTED);
    }



    @GetMapping()
    public ResponseEntity <List<Account_Model>> findAll(){
        return new ResponseEntity<List<Account_Model>>(account_service.findAll(),HttpStatus.ACCEPTED);
    }

    @GetMapping("/uds/{id}")
    public ResponseEntity <List<Account_Model>> findByCustid(@PathVariable("id") Integer id){
        return new ResponseEntity<List<Account_Model>>(account_service.findByCustid(id),HttpStatus.ACCEPTED);
    }


    @PatchMapping("/addmoney")
    public ResponseEntity <List<Account_Model>> updateMoney(@RequestBody PutRequest p){
        return new ResponseEntity<List<Account_Model>>(account_service.updateMoney(p),HttpStatus.ACCEPTED);
    }

    @PatchMapping("/disableisActive/{id}")
    public ResponseEntity <List<Account_Model>> updateActive(@PathVariable("id") Integer ids){
        return new ResponseEntity<List<Account_Model>>(account_service.updateActive(ids),HttpStatus.ACCEPTED);
    }
}
