package com.example.phonebook.models;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "contacts")
public class Contact {
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
    @OneToMany(mappedBy = "contact", fetch = FetchType.LAZY)
    private Set<Phone> phones;
}
