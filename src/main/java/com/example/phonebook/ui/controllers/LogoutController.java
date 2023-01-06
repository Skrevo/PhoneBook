package com.example.phonebook.ui.controllers;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LogoutController {
    @GetMapping("logout")
    public String logout(HttpServletRequest request, HttpServletResponse response) {
//        Authentication authentication = SecurityContextHolder
        return "redirect:";
    }
}
