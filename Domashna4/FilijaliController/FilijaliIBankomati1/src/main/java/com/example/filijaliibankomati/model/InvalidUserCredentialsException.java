package com.example.filijaliibankomati.model;

public class InvalidUserCredentialsException extends RuntimeException{

    public InvalidUserCredentialsException() {
        super("Invalid user credentials exception");
    }
}
