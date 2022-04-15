package com.example.clientsservice.controllers;

import com.example.clientsservice.controllers.tools.BootstrapManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UesrController {
    @GetMapping("users")
    public String load(Model model, @AuthenticationPrincipal Object ap){
        BootstrapManager.setBootstrapHead(model);
        System.err.println("Users: ");
        System.err.println(ap);
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return "users";
    }
}
