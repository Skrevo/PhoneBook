package com.example.phonebook.ui.controllers;

import com.example.phonebook.models.User;
import com.example.phonebook.services.data.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegistrationController {

    @Autowired
    private UserService userService;

    @PostMapping("registrationForm")
    public String regUser(@ModelAttribute User user) {
        user.setRole(User.Role.USER);
        user.setStatus(User.Status.CREATED);
        userService.save(user);
        return "redirect:authorization";
    }
}