package com.example.Customer.Model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Service;

import java.util.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Document(collection = "Customer")

public class Customer_Model {
    @Id
    private  int id;
    private String customer_name;
    private Date creation_date;
    private boolean isactive;
}
