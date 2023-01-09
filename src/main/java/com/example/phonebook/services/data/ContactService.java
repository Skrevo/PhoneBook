package com.example.phonebook.services.data;

import com.example.phonebook.models.Contact;

import java.util.List;

public interface ContactService {
    Contact save(Contact contact);
    List<Contact> findAll();
    List<Contact> findAllBySurnameAndNameAndPatronymic(String surname, String name, String patronymic);
    Contact findById(Integer id);
    List<Contact> saveAll(List<Contact> contacts);

    List<Contact> findAllByName(String searchName);
}
