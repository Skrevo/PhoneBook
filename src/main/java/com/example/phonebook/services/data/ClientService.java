package com.example.phonebook.services.data;

import com.example.phonebook.models.Client;

import java.util.List;

public interface ClientService {
    Client save(Client client);
    List<Client> findAll();
    List<Client> findAllBySurnameAndNameAndPatronymic(String surname, String name, String patronymic);
    Client findById(Integer id);
    List<Client> saveAll(List<Client> clients);
}
