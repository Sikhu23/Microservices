package com.example.Customer.Model;


//import com.vaccination_centre.Entity.VaccinationCentre;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequiredResponse {
    private List<Account_Model> account_model;
    private Customer_Model customer_model;
}





