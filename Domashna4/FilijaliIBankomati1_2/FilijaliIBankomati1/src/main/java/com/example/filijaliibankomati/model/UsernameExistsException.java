package com.example.filijaliibankomati.model;

public class UsernameExistsException extends RuntimeException{
    public UsernameExistsException(String username) {
        super(String.format("User with username: %d already exists", username));    }
}