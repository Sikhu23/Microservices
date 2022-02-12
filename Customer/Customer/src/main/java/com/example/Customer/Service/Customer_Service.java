package com.example.Customer.Service;


import com.example.Customer.Model.Customer_Model;
import com.example.Customer.Repository.Customer_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class Customer_Service  {

    @Autowired
    private Customer_Repository customer_repository;

//    @Autowired
//    private Customer_Model customer_model;

    public Customer_Model add(Customer_Model cus){
        return customer_repository.save(cus);
    }


    public Customer_Model findById(Integer cust_id){
        return customer_repository.findById(cust_id).get();
    }


    public List<Customer_Model> findAll(){
        return customer_repository.findAll();
    }

//    public String delete(Integer cust_id){
//        Customer_Model c = customer_repository.findById(cust_id).get();
//        if(c.isIsactive()==true)
//        {
//            customer_repository.save(cust_id.setIsactive(false));
//
//            return "Customer ID succesfully deactivated";
//
//        }
//
//        else
//            return "Customer ID is Already inactive";
//
//
//
//    }
}
