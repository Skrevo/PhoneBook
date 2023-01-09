package com.example.phonebook.services.data.db;

import com.example.phonebook.models.Contact;
import com.example.phonebook.repositories.ContactRepository;
import com.example.phonebook.services.data.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ContactServiceDb implements ContactService {

    @Autowired
    private ContactRepository contactRepository;

    @Override
    public Contact save(Contact contact) {
        return contactRepository.save(contact);
    }

    @Override
    public List<Contact> findAll() {
        return contactRepository.findAll();
    }

    @Override
    public List<Contact> findAllBySurnameAndNameAndPatronymic(String surname, String name, String patronymic) {
        return contactRepository.findAllBySurnameAndNameAndPatronymic(surname, name, patronymic);
    }

    @Override
    public Contact findById(Integer id) {
        return contactRepository.findById(id).get();
    }

    @Override
    public List<Contact> saveAll(List<Contact> contacts) {
        return contactRepository.saveAll(contacts);
    }

    @Override
    public List<Contact> findAllByName(String searchName) {
        return contactRepository.findAllByName(searchName);
    }
}
