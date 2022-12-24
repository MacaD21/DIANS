package com.example.filijaliibankomati.service;

import com.example.filijaliibankomati.model.Bankomati;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

public interface BankomatiService {
    Bankomati findById(Long id);
    List<Bankomati> showAll();
    Bankomati searchByName(String name);
    List<Bankomati> searchByCity(String city);
    Set<String> showCities();
}
