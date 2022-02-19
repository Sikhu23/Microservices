package com.example.Customer.Model;


import com.example.Customer.Enum.CustomerType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.*;

import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Document(collection = "Customer")

public class Customer_Model {
    @Id
    @Min(0)
    @Max(999)
    private  int customerId;

    @NotEmpty(message = "Name cannot be empty")
    private String customerFirstName;

    private String customerMiddleName;

    @NotEmpty(message = "Last name cannot be empty")
    private String customerLastName;

    @NotEmpty(message = "Address cannot be empty")
    private String address;


    @NotNull(message = "creation date can't be null")
    private Date creation_date;

    @NotNull(message = "isactive can't be null")
    private boolean isactive;

    @NotNull(message = "Customer Type can't be null")
    private CustomerType customerType;

    @NotNull(message = "Phone number  can't be null")
    @Size(min=10,max = 10)
    private String phonenumber;


    @NotNull(message = "Email can't be null")
    private String email;


    private Account_Model accountModel;




    private LocalDateTime current_date= LocalDateTime.now();


    public boolean getisactive(){
        return this.isactive;
    }
}
