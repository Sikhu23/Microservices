package com.example.Customer.Exception;
import org.springframework.stereotype.Component;

public class CustomerAlreadyExistsException extends RuntimeException {
    public CustomerAlreadyExistsException(String message) {
        super(message);
    }
}
