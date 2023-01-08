package com.example.phonebook.services.data.db;

import com.example.phonebook.models.Client;
import com.example.phonebook.repositories.ClientRepository;
import com.example.phonebook.services.data.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
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

    @Override
    public List<Client> findAllBySurnameAndNameAndPatronymic(String surname, String name, String patronymic) {
        return clientRepository.findAllBySurnameAndNameAndPatronymic(surname, name, patronymic);
    }

    @Override
    public Client findById(Integer id) {
        return clientRepository.findById(id).get();
    }

    @Override
    public List<Client> saveAll(List<Client> clients) {
        return clientRepository.saveAll(clients);
    }

    @Override
    public List<Client> findAllByName(String searchName) {
        return clientRepository.findAllByName(searchName);
    }
}
