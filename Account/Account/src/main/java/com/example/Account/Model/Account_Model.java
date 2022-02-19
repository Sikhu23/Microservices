package com.example.Account.Model;


import com.example.Account.Enum.AccountType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Account_Model {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int account_id;

    private int custid;
    private Date account_creation_date;
    private float account_balance;

    private boolean isactive;

    @Enumerated(EnumType.STRING)
    private AccountType accountType ;

}
