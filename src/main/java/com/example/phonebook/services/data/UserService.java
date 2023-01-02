package com.example.phonebook.services.data;

import com.example.phonebook.models.User;

import java.util.List;

public interface UserService {
    List<User> findAll();

    User save(User user);

    User findById(Integer id);

    User findByUsername(String username);

    List<User> saveAll(List<User> users);
}
