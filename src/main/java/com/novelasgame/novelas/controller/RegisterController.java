package com.novelasgame.novelas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.novelasgame.novelas.entity.User;
import com.novelasgame.novelas.service.UserServiceImpl;

@Controller
@RequestMapping("/registration")
public class RegisterController {

    @Autowired
    UserServiceImpl userService;

    @GetMapping
    public String getRegistration() {
        return "login";
    }
    
    @PostMapping
    public String setRegistrationForm(Model model, @ModelAttribute User user) {
        System.out.println("start registration");
        boolean success = userService.userRegistration(user);
        String response = success ? "Success registration" : "Registration failed";
        System.out.println("registration users: "+response);
        model.addAttribute("success", response);
        return "login";
    }
}
