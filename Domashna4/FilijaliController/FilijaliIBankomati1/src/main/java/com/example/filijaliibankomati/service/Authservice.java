package com.example.filijaliibankomati.service;

import com.example.filijaliibankomati.model.User;

import java.io.IOException;

public interface Authservice {

    User login(String username, String password);
    User register(String username, String password, String repeatPassword, String name, String surname) throws IOException;
}
