package com.example.phonebook.ui.controllers;

import com.example.phonebook.services.data.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class SearchNameController {

    @Autowired
    public ClientService clientService;
}
