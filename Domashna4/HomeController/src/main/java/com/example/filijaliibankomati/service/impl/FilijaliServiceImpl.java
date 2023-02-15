package com.example.filijaliibankomati.service.impl;

import com.example.filijaliibankomati.model.Filijali;
import com.example.filijaliibankomati.repository.FilijaliRepository;
import com.example.filijaliibankomati.service.FilijaliService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class FilijaliServiceImpl implements FilijaliService {
    private final FilijaliRepository filijaliRepository;

    public FilijaliServiceImpl(FilijaliRepository filijaliRepository) {
        this.filijaliRepository = filijaliRepository;
    }

    @Override
    public Filijali findById(Long id) {
        return this.filijaliRepository.findById(id).orElseThrow();    }

    @Override
    public List<Filijali> showAll() {
        return this.filijaliRepository.listAll();
    }

    @Override
    public Filijali searchByName(String name) {
        return this.filijaliRepository.findByName(name);    }

    @Override
    public List<Filijali> searchByCity(String city) {
        return this.filijaliRepository.findByCity(city);
    }
    @Override
    public Set<String> showCities() {
        return this.filijaliRepository.listCities();
    }
}
