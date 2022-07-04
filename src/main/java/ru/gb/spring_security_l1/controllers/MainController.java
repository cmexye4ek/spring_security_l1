package ru.gb.spring_security_l1.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.gb.spring_security_l1.models.User;
import ru.gb.spring_security_l1.services.UserService;

import java.security.Principal;

@RestController
public class MainController {
    private final UserService userService;

    public MainController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String homePage() {
        return "home";
    }

    @GetMapping("/admin")
    public String adminPage() {
        return "admin";
    }

    @GetMapping("/manager")
    public String managerPage() {
        return "manager";
    }

    @GetMapping("/user")
    public String userPage() {
        return "user";
    }

    @GetMapping("/user_info")
    public String getUser(Principal principal) {
        User user = userService
                .findByUsername(principal.getName())
                .orElseThrow(() -> new RuntimeException("Unable to find user by username: " + principal.getName()));
        return "Authenticated user info: " + user.getUsername() + " : " + user.getEmail() + "\n" + user.getRolesToString();
    }
}