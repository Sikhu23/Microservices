package com.example.Customer.Model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PutRequest {
    private int id;
    private String lastname;
    private String middlename;
    private String address;
    @Size(min=10,max=10)
    private String phone;
    private String email;
}
