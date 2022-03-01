package com.example.Customer.Service;


import com.example.Customer.Exception.CustomerAlreadyExistsException;
import com.example.Customer.Exception.CustomerNotFoundException;
import com.example.Customer.Feign.Feign;
import com.example.Customer.Model.Account_Model;
import com.example.Customer.Model.Customer_Model;
import com.example.Customer.Repository.Customer_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.Customer.Model.PutRequest;
import java.util.*;

@Service
public class Customer_Service  {

    @Autowired
    private Customer_Repository customer_repository;

    @Autowired
    private Feign feign;




    public Customer_Model add(Customer_Model cus){
        if( !customer_repository.findById(cus.getCustomerId()).isPresent()){
//        Customer_Model customerModel = customer_repository.findById(cus.getCustomerId()).get();


                Account_Model accountModel = feign.createAccount(cus.getAccountModel());



                return customer_repository.save(cus);


        }
        else{
            Customer_Model customerModel = customer_repository.findById(cus.getCustomerId()).get();
            if(customerModel.getisactive()==true){
                Account_Model accountModel= feign.createAccount(cus.getAccountModel());
                return customer_repository.save(cus);
            }
            else{
                throw new CustomerNotFoundException("Customer is already inactive,cannnot create account") ;
            }


            }
        }

    public Customer_Model findById(Integer cust_id){
        if(!customer_repository.findById(cust_id).isPresent())
            throw new CustomerNotFoundException("id doesnt exist");
        Customer_Model c= customer_repository.findById(cust_id).get();
        c.setAccountModel(null);

        return c;
    }


    public List<Customer_Model> findAll(){
        if(customer_repository.findAll().isEmpty())
            throw new CustomerAlreadyExistsException("No customer found for this id");
        List<Customer_Model> c= customer_repository.findAll();
        for(Customer_Model c1 : c){
            c1.setAccountModel(null);
        }

        return c;
    }

//
//    public Customer_Model deleteCust(Integer id){
//        Customer_Model cus = customer_repository.findById(id).get();
//
//        if(cus.getisactive()==false)
//            throw new CustomerAlreadyExistsException("Customer is already inactive");
//        else {
//            cus.setIsactive(false);
//            customer_repository.save(cus);
//            List<Account_Model> accountLists = (List<Account_Model>) feign.updateActive(id);
//            cus = findById(id);
//            return cus;
//        }
//    }

    public Customer_Model deleteCust(Integer id){
        Customer_Model cus = findById(id);
        if(cus.getisactive()==false) {
            throw new CustomerAlreadyExistsException("Customer is already inactive");
        }
        cus.setIsactive(false);
        customer_repository.save(cus);
        List<Account_Model> accountLists = (List<Account_Model>) feign.updateActive(id);
        cus = findById(id);
        return cus;
    }
    public Customer_Model updateLastName(PutRequest p){
        Customer_Model cus = findById(p.getId());
        cus.setCustomerLastName(p.getLastname());
        customer_repository.save(cus);
        return cus = findById(p.getId());

    }

    public Customer_Model updateMiddleName(PutRequest p){
        Customer_Model cus = findById(p.getId());
        cus.setCustomerMiddleName(p.getMiddlename());
        customer_repository.save(cus);
        return cus = findById(p.getId());

    }

    public Customer_Model updateAddress(PutRequest p){
        Customer_Model cus = findById(p.getId());
        cus.setAddress(p.getAddress());
        customer_repository.save(cus);
        return cus = findById(p.getId());

    }

    public Customer_Model updatePhone(PutRequest p){
        Customer_Model cus = findById(p.getId());
        cus.setPhonenumber(p.getPhone());
        customer_repository.save(cus);
        return cus = findById(p.getId());

    }

    public Customer_Model updateEmail(PutRequest p){
        Customer_Model cus = findById(p.getId());
        cus.setEmail(p.getEmail());
        customer_repository.save(cus);
        return cus = findById(p.getId());

    }
}
