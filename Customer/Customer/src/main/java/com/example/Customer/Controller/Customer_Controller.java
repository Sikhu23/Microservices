package com.example.Customer.Controller;


import com.example.Customer.Model.Account_Model;
import com.example.Customer.Model.Customer_Model;
import com.example.Customer.Model.RequiredResponse;
import com.example.Customer.Service.Customer_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/customer")
public class Customer_Controller {

    @Autowired
    private Customer_Service customer_service;

    @Autowired
    private RestTemplate restTemplate;

    @PostMapping
    public ResponseEntity <Customer_Model> save(@RequestBody Customer_Model cus){
        return new ResponseEntity<Customer_Model>(customer_service.add(cus), HttpStatus.ACCEPTED);
    }

//    @GetMapping("/id/{id}")
//    public ResponseEntity <Customer_Model> findById(@PathVariable("id") Integer cust_id){
//        return new ResponseEntity<Customer_Model>(customer_service.findById(cust_id),HttpStatus.ACCEPTED);
//    }



    @GetMapping()
    public ResponseEntity <List<Customer_Model>> findAll(){
        return new ResponseEntity<List<Customer_Model>>(customer_service.findAll(),HttpStatus.ACCEPTED);
    }


    @GetMapping("/id/{id}")
    public ResponseEntity<RequiredResponse> getAllDataBasedOnCentreId(@PathVariable("id") Integer id){
        RequiredResponse requiredResponse=new RequiredResponse();


        Customer_Model cm=  customer_service.findById(id);
        requiredResponse.setCustomer_model(cm);

        Account_Model accountLists=  restTemplate.getForObject("http://ACCOUNT-SERVICE/account/id/"+id,Account_Model.class);
        requiredResponse.setAccount_model((Account_Model) accountLists);
        return new ResponseEntity<RequiredResponse>(requiredResponse,HttpStatus.OK);
    }

//
//    @PatchMapping("/id/{id}")
//    public ResponseEntity<String> delete(@PathVariable("id") Integer cust_id){
//
//        return new ResponseEntity<String>(customer_service.delete(cust_id),HttpStatus.ACCEPTED);
//    }
}
