package com.example.Account.Model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Account_Model {

    private int account_id;
    @Id
    private int id;
    private Date account_creation_date;
    private float account_balance;
}
