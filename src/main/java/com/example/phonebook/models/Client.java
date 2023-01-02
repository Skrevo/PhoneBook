package com.example.phonebook.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "clients")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(length = 50, nullable = false)
    private String surname;
    @Column(length = 50, nullable = false)
    private String name;
    @Column(length = 50, nullable = false)
    private String patronymic;
    @Column(length = 50, nullable = false, unique = true)
    private String email;
    @OneToOne(fetch = FetchType.LAZY)
    private Address address;
    @OneToMany(mappedBy = "client", fetch = FetchType.LAZY)
    private Set<Phone> phones;
}
