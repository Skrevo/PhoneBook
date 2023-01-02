package com.example.phonebook.services.data.db;

import com.example.phonebook.models.Address;
import com.example.phonebook.repositories.AddressRepository;
import com.example.phonebook.services.data.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressServiceDb implements AddressService {

    @Autowired
    private AddressRepository addressRepository;

    @Override
    public Address save(Address address) {
        return addressRepository.save(address);
    }
}
