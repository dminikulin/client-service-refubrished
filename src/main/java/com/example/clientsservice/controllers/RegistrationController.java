package com.example.clientsservice.controllers;

import com.example.clientsservice.controllers.tools.BootstrapManager;
import com.example.clientsservice.models.User;
import com.example.clientsservice.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

@Controller
public class RegistrationController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("registration")
    public String load(Model model){
        BootstrapManager.setBootstrapHead(model);
        return "registration";
    }

    @PostMapping("register")
    public ModelAndView register(@RequestParam String login,
                                 @RequestParam String email,
                                 @RequestParam String password,
                                 ModelMap model
    ){
        User user = new User(0L, login, email, password, User.Status.ACTIVE,
                Collections.singleton(User.Role.USER));
        System.err.println("Registration found: " + userRepository.findByLogin(login));
        if(userRepository.findByLogin(login) == null){
            user = userRepository.save(user);
            System.err.println("Registration saved: " + user);
            return new ModelAndView("redirect:registration");
        }
        else{
            model.addAttribute("message", "User " + login + " already exists");
            return new ModelAndView("redirect:error", model);
        }
    }
}
