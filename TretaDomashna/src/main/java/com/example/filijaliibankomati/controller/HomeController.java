package com.example.filijaliibankomati.controller;

import com.example.filijaliibankomati.model.Filijali;
import com.example.filijaliibankomati.service.BankomatiService;
import com.example.filijaliibankomati.service.FilijaliService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/home")
public class HomeController {
    private final BankomatiService bankomatiService ;
    private final FilijaliService filijaliService;
    private String city;
    private Model model;

    public HomeController(BankomatiService bankomatiService, FilijaliService filijaliService) {
        this.bankomatiService = bankomatiService;
        this.filijaliService = filijaliService;
    }

    @GetMapping
    public String getType(Model model){
        return "home";
    }


    @GetMapping("/select")
    public String getSelected(@RequestParam("izbor") String izbor, Model model){
        if(izbor.equals("bankomatifilijali")){
            return "mapa";
        }
        else if(izbor.equals("detali")) {
            model.addAttribute("cities",filijaliService.showCities()) ;
            return "selectType";
        }
         return "kontakt";
    }

    @GetMapping("/selectType")
    public String getCities( @RequestParam("city") String city,  Model model){
        model.addAttribute("banki",filijaliService.searchByCity(city));
        System.out.println(filijaliService.searchByCity(city));
        return "choose";
    }


    @GetMapping("/showDetails/{id}")
    public String choose(@PathVariable Long id, Model model){
        Filijali filijala = filijaliService.findById(id);
        model.addAttribute("filijala",filijala);
        return "showDetails";
    }
}
