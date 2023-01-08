package com.example.phonebook.ui.controllers;

import com.example.phonebook.models.Client;
import com.example.phonebook.services.data.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ContactsController {
    @Autowired
    public ClientService clientService;


    @GetMapping("contacts")
    public String load(Model model) {
        List<Client> list = clientService.findAll();
        model.addAttribute("contacts", list);
        return "contacts";
    }

    @PostMapping("addContactForm")
    public String addContactForm(@ModelAttribute Client client) {
        clientService.save(client);
        return "redirect:contacts";
    }

    @PostMapping("openContactForm")
    public ModelAndView openContactForm(Integer id){
        return new ModelAndView("redirect:contactUpdate", new ModelMap("id", id));
    }

    @PostMapping("searchNameForm")
    public ModelAndView searchNameForm(String searchName) {
        return new ModelAndView("redirect:searchContact", new ModelMap("searchName", searchName));
    }
}
