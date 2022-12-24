package com.example.filijaliibankomati.service;

import com.example.filijaliibankomati.model.Bankomati;
import com.example.filijaliibankomati.model.Filijali;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
public interface FilijaliService {
    Filijali findById(Long id);
    List<Filijali> showAll();
    Filijali searchByName(String name);
    List<Filijali> searchByCity(String city);
    Set<String> showCities();
}
