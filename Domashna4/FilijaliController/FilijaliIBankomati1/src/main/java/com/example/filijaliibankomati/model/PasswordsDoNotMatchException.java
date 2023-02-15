package com.example.filijaliibankomati.model;

public class PasswordsDoNotMatchException extends RuntimeException{
    public PasswordsDoNotMatchException() {
        super("Passwords do not match.");
    }
}
