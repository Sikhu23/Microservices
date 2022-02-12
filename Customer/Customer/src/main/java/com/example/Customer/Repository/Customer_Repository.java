package com.example.Customer.Repository;

import com.example.Customer.Model.Customer_Model;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface Customer_Repository extends MongoRepository<Customer_Model,Integer> {
}
