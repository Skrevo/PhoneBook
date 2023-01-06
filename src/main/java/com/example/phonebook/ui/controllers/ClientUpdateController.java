package com.example.phonebook.ui.controllers;

import com.example.phonebook.models.Address;
import com.example.phonebook.models.Client;
import com.example.phonebook.models.Phone;
import com.example.phonebook.services.data.AddressService;
import com.example.phonebook.services.data.ClientService;
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
public class ClientUpdateController {
    @Autowired
    private ClientService clientService;

    @Autowired
    private AddressService addressService;

    @Autowired
    private PhoneService phoneService;

    @GetMapping("clientUpdate")
    public String load(@RequestParam("id") Integer id, Model model) {
        Client client = clientService.findById(id);
        if (client.getAddress() == null)
            client.setAddress(new Address());
        model.addAttribute("client", client);
        model.addAttribute("address", client.getAddress());
        model.addAttribute("phones", client.getPhones());
        return "clientUpdate";
    }

    @PostMapping("updateClientAddressForm")
    public ModelAndView updateClientAddressForm(
            @ModelAttribute Client client,
            @ModelAttribute Address address,
            @ModelAttribute Phone phone,
            @RequestParam(value = "idAddress", required = false) Long idAddress
    ){
        phone.setId(phone.getId());
        phone.setClient(client);
        phoneService.save(phone);
        address.setId(idAddress);
        address.setClient(client);
        address = addressService.save(address);
        client.setAddress(address);
        clientService.save(client);
        return new ModelAndView("redirect:clientUpdate",
                new ModelMap("id",client.getId()));
    }
}
