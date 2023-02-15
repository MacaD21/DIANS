package com.example.filijaliibankomati.controller;

import com.example.filijaliibankomati.model.InvalidUserCredentialsException;
import com.example.filijaliibankomati.model.User;
import com.example.filijaliibankomati.service.Authservice;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(" ")
public class LoginController {

    private final Authservice authservice;

    public LoginController(Authservice authservice) {
        this.authservice = authservice;
    }

    @GetMapping
    public String getLoginPage(Model model){
        return "login";

    }

    @PostMapping("/login")
    public String login(HttpServletRequest request, Model model){
        User user=null;

        try{

            user = this.authservice.login(request.getParameter("username"),request.getParameter("password"));
            request.getSession().setAttribute("user",user);
            return "redirect:/home";

        }catch(InvalidUserCredentialsException exception){
            model.addAttribute("hasError",true);
            model.addAttribute("error",exception.getMessage());
            return "login";
        }
    }

}
