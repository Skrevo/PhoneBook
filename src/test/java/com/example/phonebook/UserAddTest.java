package com.example.phonebook;

import com.example.phonebook.models.User;
import com.example.phonebook.services.data.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootTest
public class UserAddTest {

    @Autowired
    private UserService userService;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Test
    public void addUser() {
        User user = new User(0,"u","u", User.Role.ADMIN, User.Status.ACTIVE,"u@mail");
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userService.save(user);
    }
}
