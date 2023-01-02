package com.example.phonebook.services.data.db;

import com.example.phonebook.models.Phone;
import com.example.phonebook.repositories.PhoneRepository;
import com.example.phonebook.services.data.PhoneService;
import org.springframework.beans.factory.annotation.Autowired;

public class PhoneServiceDb implements PhoneService {

    @Autowired
    private PhoneRepository phoneRepository;

    @Override
    public Phone save(Phone phone) {
        return phoneRepository.save(phone);
    }
}
