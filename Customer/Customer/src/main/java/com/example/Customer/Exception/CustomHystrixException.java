package com.example.Customer.Exception;

public class CustomHystrixException extends RuntimeException{
    public CustomHystrixException(String message) {
        super(message);
    }
}
