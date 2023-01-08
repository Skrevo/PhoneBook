package com.example.phonebook.ui.controllers;

import com.example.phonebook.models.Client;
import com.example.phonebook.services.data.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class SearchNameController {

    @Autowired
    public ClientService clientService;

    @GetMapping("searchContact")
    public String load(@RequestParam("searchName") String searchName, Model model) {
        List<Client> list = clientService.findAllByName(searchName);
        model.addAttribute("contacts", list);
        return "searchContact";

    }
}
