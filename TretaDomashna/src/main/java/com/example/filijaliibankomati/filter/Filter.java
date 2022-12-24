package com.example.filijaliibankomati.filter;

public interface Filter <T>{
    T execute(T input);
}
