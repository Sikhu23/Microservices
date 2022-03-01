package com.example.Customer.Feign;

import com.example.Customer.Model.Account_Model;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@FeignClient(name="ACCOUNT-SERVICE" ,fallbackFactory = HysterixFallback.class)
//@LoadBalancerClient(name = "mail-service", configuration = HysterixFallback.class)
public interface Feign {

    @GetMapping("/account/uds/{id}")
    List<Account_Model> findIDS(@PathVariable Integer id);


    @PatchMapping("/account/disableisActive/{id}")
    List<Account_Model> updateActive(@PathVariable Integer id);


    @PostMapping("/account")
    Account_Model createAccount(@RequestBody Account_Model accountModel);

}
