package com.example.filijaliibankomati.service.impl;

import com.example.filijaliibankomati.model.Bankomati;
import com.example.filijaliibankomati.repository.BankomatiRepository;
import com.example.filijaliibankomati.service.BankomatiService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class BankomatiServiceImpl implements BankomatiService {
    private final BankomatiRepository bankomatiRepository;

    public BankomatiServiceImpl(BankomatiRepository bankomatiRepository) {
        this.bankomatiRepository = bankomatiRepository;
    }

    @Override
    public Bankomati findById(Long id) {
        return this.bankomatiRepository.findById(id).orElseThrow();
    }

    @Override
    public List<Bankomati> showAll() {
        return this.bankomatiRepository.listAll();
    }

    @Override
    public Bankomati searchByName(String name) {
        return this.bankomatiRepository.findByName(name);
    }

    @Override
    public List<Bankomati> searchByCity(String city) {
        return this.bankomatiRepository.findByCity(city);
    }

    @Override
    public Set<String> showCities() {
        return this.bankomatiRepository.listCities();
    }
}
