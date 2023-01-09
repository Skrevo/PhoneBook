package com.example.phonebook.ui.controllers;

import com.example.phonebook.models.Contact;
import com.example.phonebook.services.data.ContactService;
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
    public ContactService contactService;


    @GetMapping("contacts")
    public String load(Model model) {
        List<Contact> list = contactService.findAll();
        model.addAttribute("contacts", list);
        return "contacts";
    }

    @PostMapping("addContactForm")
    public String addContactForm(@ModelAttribute Contact contact) {
        contactService.save(contact);
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
