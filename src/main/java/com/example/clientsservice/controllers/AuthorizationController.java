package com.example.clientsservice.controllers;

import com.example.clientsservice.controllers.tools.BootstrapManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

//@Controller
public class AuthorizationController {
    @GetMapping("authorization")
    public String load(Model model){
        BootstrapManager.setBootstrapHead(model);
        return "authorization";
    }
}
