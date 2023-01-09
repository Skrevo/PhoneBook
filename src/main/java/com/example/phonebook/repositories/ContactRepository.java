package com.example.phonebook.repositories;

import com.example.phonebook.models.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ContactRepository extends JpaRepository<Contact, Integer> {
    List<Contact> findAllBySurnameAndNameAndPatronymic(String surname, String name, String patronymic);

    List<Contact> findAllByName(String name);
}
