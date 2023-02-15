package com.example.filijaliibankomati.model;

public class PalceDoesNotExist extends RuntimeException{
    public PalceDoesNotExist() {
        super("The searched place does not exist");
    }
}
