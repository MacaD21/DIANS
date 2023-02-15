package com.example.filijaliibankomati.controller;

import com.example.filijaliibankomati.model.InvalidArgumentsException;
import com.example.filijaliibankomati.model.PasswordsDoNotMatchException;
import com.example.filijaliibankomati.service.Authservice;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;

@Controller
@RequestMapping("/register")
public class RegisterController {

    private final Authservice authservice;

    public RegisterController(Authservice authservice) {
        this.authservice = authservice;
    }

    @GetMapping
    public String getRegisterPage(@RequestParam(required = false) String error, Model model){
        if(error!=null && !error.isEmpty()){
            model.addAttribute("hasError",true);
            model.addAttribute("error",error);
        }
        return "register";

    }
    @PostMapping
    public String register(@RequestParam String username,
                           @RequestParam String password,
                           @RequestParam String repeatedPassword,
                           @RequestParam String name,
                           @RequestParam String surname) throws IOException {
        try {
            this.authservice.register(username, password, repeatedPassword, name, surname);
            return "redirect:/login";
        }catch (PasswordsDoNotMatchException | InvalidArgumentsException exception){
            return "redirect:/register?error= "+exception.getMessage();
        }
    }
}
