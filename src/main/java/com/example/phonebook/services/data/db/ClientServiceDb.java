package com.example.phonebook.services.data.db;

import com.example.phonebook.models.Client;
import com.example.phonebook.repositories.ClientRepository;
import com.example.phonebook.services.data.ClientService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ClientServiceDb implements ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public Client save(Client client) {
        return clientRepository.save(client);
    }

    @Override
    public List<Client> findAll() {
        return clientRepository.findAll();
    }
}
