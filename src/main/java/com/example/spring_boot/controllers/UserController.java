package com.example.spring_boot.controllers;
import com.example.spring_boot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.security.Principal;

public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/user")
    public String getUser(Model model, Principal principal) {
        model.addAttribute("user", userService.getUserByName(principal.getName()));
        return "showUser";
    }
}
