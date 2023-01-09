package com.example.phonebook.ui.controllers;

import com.example.phonebook.models.Contact;
import com.example.phonebook.services.data.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class SearchNameController {

    @Autowired
    public ContactService contactService;

    @GetMapping("searchContact")
    public String load(@RequestParam("searchName") String searchName, Model model) {
        List<Contact> list = contactService.findAllByName(searchName);
        model.addAttribute("contacts", list);
        return "searchContact";

    }
}
