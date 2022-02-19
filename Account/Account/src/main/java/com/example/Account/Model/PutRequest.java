package com.example.Account.Model;

import com.example.Account.Enum.AccountType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PutRequest {
    private int money;
    private int id;
    private AccountType acctype;

}
