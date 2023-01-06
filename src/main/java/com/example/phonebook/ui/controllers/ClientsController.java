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
public class ClientsController {
    @Autowired
    public ClientService clientService;


    @GetMapping("clients")
    public String load(Model model) {
        List<Client> list = clientService.findAll();
        model.addAttribute("clients", list);
        return "clients";
    }

    @PostMapping("addClientForm")
    public String addClientForm(@ModelAttribute Client client) {
        clientService.save(client);
        return "redirect:clients";
    }

    @PostMapping("openClientForm")
    public ModelAndView openClientForm(Integer id){
        return new ModelAndView("redirect:clientUpdate", new ModelMap("id", id));
    }
}
