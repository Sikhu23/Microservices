package com.example.Customer.Feign;

import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;


@Component
public class HysterixFallback implements FallbackFactory<Feign> {
    @Override
    public Feign create(Throwable cause) {

//        System.out.println("the res");


            System.out.println("Fallbaherghiuergerljg56ck reason is " + cause.getMessage());
            return null;

    }
}
