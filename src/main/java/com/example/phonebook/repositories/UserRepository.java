package com.example.phonebook.repositories;

import com.example.phonebook.models.Client;
import com.example.phonebook.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {

    User findByUsername(String username);
}
