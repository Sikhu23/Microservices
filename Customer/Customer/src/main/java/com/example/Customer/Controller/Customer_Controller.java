package com.example.Customer.Controller;


import com.example.Customer.Feign.Feign;
import com.example.Customer.Model.Account_Model;
import com.example.Customer.Model.Customer_Model;
import com.example.Customer.Model.RequiredResponse;
import com.example.Customer.Service.Customer_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import com.example.Customer.Model.PutRequest;

import javax.validation.Valid;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/customer")
public class Customer_Controller {

    @Autowired
    private Customer_Service customer_service;

//    @Autowired
//    private RestTemplate restTemplate;

    @Autowired
    Feign feign;

    @PostMapping
    public ResponseEntity<Customer_Model> save(@Valid @RequestBody Customer_Model cus){
        return new ResponseEntity<Customer_Model>(customer_service.add(cus), HttpStatus.ACCEPTED);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity <Customer_Model> findById(@PathVariable("id") Integer cust_id){
        return new ResponseEntity<Customer_Model>(customer_service.findById(cust_id),HttpStatus.ACCEPTED);
    }



    @GetMapping()
    public ResponseEntity <List<Customer_Model>> findAll(){
        return new ResponseEntity<List<Customer_Model>>(customer_service.findAll(),HttpStatus.ACCEPTED);
    }




    @GetMapping("/feign/id/{id}")
    public ResponseEntity<RequiredResponse> getAllDataBasedOnCentreId(@PathVariable("id") Integer id){
        RequiredResponse requiredResponse=new RequiredResponse();


        Customer_Model cm=  customer_service.findById(id);
        requiredResponse.setCustomer_model(cm);


        //Account_Model accountLists=  restTemplate.getForObject("http://ACCOUNT-SERVICE/account/id/"+id,Account_Model.class);
        List<Account_Model> accountLists = feign.findIDS(id);

        requiredResponse.setAccount_model(accountLists);
        return new ResponseEntity<RequiredResponse>(requiredResponse,HttpStatus.OK);
    }

//
    @PatchMapping("/updateActive/{id}")
    public ResponseEntity<Customer_Model> delete(@PathVariable("id") Integer id){

        return new ResponseEntity<Customer_Model>(customer_service.deleteCust(id),HttpStatus.ACCEPTED);
    }

    @PatchMapping("/updateLastName")
    public ResponseEntity<Customer_Model> updateLastName(@RequestBody PutRequest p){
        return new ResponseEntity<Customer_Model>(customer_service.updateLastName(p),HttpStatus.ACCEPTED);
    }

    @PatchMapping("/updateMiddleName")
    public ResponseEntity<Customer_Model> updateMiddleName(@RequestBody PutRequest p){
        return new ResponseEntity<Customer_Model>(customer_service.updateMiddleName(p),HttpStatus.ACCEPTED);
    }

    @PatchMapping("/updateAddress")
    public ResponseEntity<Customer_Model> updateAddress(@RequestBody PutRequest p){
        return new ResponseEntity<Customer_Model>(customer_service.updateAddress(p),HttpStatus.ACCEPTED);
    }

    @PatchMapping("/updatePhone")
    public ResponseEntity<Customer_Model> updatePhone(@RequestBody PutRequest p){
        return new ResponseEntity<Customer_Model>(customer_service.updatePhone(p),HttpStatus.ACCEPTED);
    }

    @PatchMapping("/updateEmail")
    public ResponseEntity<Customer_Model> updateEmail(@RequestBody PutRequest p){
        return new ResponseEntity<Customer_Model>(customer_service.updateEmail(p),HttpStatus.ACCEPTED);
    }
}
