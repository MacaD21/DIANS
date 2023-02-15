package com.example.filijaliibankomati.controller;

import com.example.filijaliibankomati.model.Filijali;
import com.example.filijaliibankomati.service.FilijaliService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Controller
@RequestMapping("/home")
public class HomeController {
    private final RestTemplate restTemplate;
    public HomeController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping
    public String getType(){
        return "home";
    }

    @GetMapping("/select")
    public String getSelected(@RequestParam("izbor") String izbor, Model model){
        if(izbor.equals("bankomatifilijali")){
            return "mapa";
        }
        else if(izbor.equals("detali")) {
            List<String> cities = restTemplate.getForObject("http://filijali-service/filijali/cities", List.class);
            model.addAttribute("cities", cities);
            return "selectType";
        }
        return "kontakt";
    }

    @GetMapping("/selectType")
    public String getCities(@RequestParam("city") String city, Model model){
        List<Filijali> banki = restTemplate.getForObject("http://filijali-service/filijali/city/" + city, List.class);
        model.addAttribute("banki", banki);
        return "choose";
    }

    @GetMapping("/showDetails/{id}")
    public String choose(@PathVariable Long id) {
        return "choose";
    }
    }