package com.example.phonebook.ui.controllers;

import com.example.phonebook.models.Address;
import com.example.phonebook.models.Contact;
import com.example.phonebook.models.Phone;
import com.example.phonebook.services.data.AddressService;
import com.example.phonebook.services.data.ContactService;
import com.example.phonebook.services.data.PhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ContactUpdateController {
    @Autowired
    private ContactService contactService;

    @Autowired
    private AddressService addressService;

    @Autowired
    private PhoneService phoneService;

    @GetMapping("contactUpdate")
    public String load(@RequestParam("id") Integer id, Model model) {
        Contact contact = contactService.findById(id);
        if (contact.getAddress() == null)
            contact.setAddress(new Address());
        model.addAttribute("contact", contact);
        model.addAttribute("address", contact.getAddress());
        model.addAttribute("phones", contact.getPhones());
        return "contactUpdate";
    }

    @PostMapping("updateContactForm")
    public ModelAndView updateContactForm(
            @ModelAttribute Contact contact,
            @ModelAttribute Address address,
            @ModelAttribute Phone phone,
            @RequestParam(value = "idAddress", required = false) Long idAddress
    ){
        phone.setId(phone.getId());
        phone.setContact(contact);
        phoneService.save(phone);
        address.setId(idAddress);
        address.setContact(contact);
        address = addressService.save(address);
        contact.setAddress(address);
        contactService.save(contact);
        return new ModelAndView("redirect:contactUpdate",
                new ModelMap("id", contact.getId()));
    }

    @GetMapping("backToContacts")
    public String backToContacts() {
        return "redirect:contacts";
    }
}
