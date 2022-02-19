package com.example.Customer.Model;



import com.example.Customer.Enum.AccountType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class Account_Model {

    private int account_id;

    private int custid;
    private Date account_creation_date;
    private float account_balance;

    private boolean isactive;



    private AccountType accountType ;

}
