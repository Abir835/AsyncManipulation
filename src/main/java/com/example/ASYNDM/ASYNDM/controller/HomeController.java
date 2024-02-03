package com.example.ASYNDM.ASYNDM.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
public class HomeController {
    @GetMapping("/")
    public String home(Model model, Principal principal) {
        boolean loggedIn = (principal != null);
        model.addAttribute("loggedIn", loggedIn);
        return "index";
    }

}
