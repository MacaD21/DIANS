package com.example.filijaliibankomati.controller;

import com.example.filijaliibankomati.model.Filijali;
import com.example.filijaliibankomati.service.FilijaliService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/filijali")
public class FilijaliController {

    private final FilijaliService filijaliService;

    public FilijaliController(FilijaliService filijaliService) {
        this.filijaliService = filijaliService;
    }

    @GetMapping("/cities")
    public List<String> showCities(){
        return (List<String>) filijaliService.showCities();
    }

    @GetMapping("/city/{city}")
    public List<Filijali> searchByCity(@PathVariable String city){
        return filijaliService.searchByCity(city);
    }

    @GetMapping("/{id}")
    public Filijali findById(@PathVariable Long id){
        return filijaliService.findById(id);
    }
}