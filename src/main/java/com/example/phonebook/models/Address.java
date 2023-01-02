package com.example.phonebook.models;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "addresses")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String region;
    @Column(nullable = false)
    private String district;
    @Column(nullable = false)
    private String city;
    @Column(nullable = false)
    private String street;
    @Column(nullable = false)
    private String house;
    @OneToOne(mappedBy = "address", fetch = FetchType.LAZY)
    @JoinColumn(foreignKey = @ForeignKey(name = "FK_address_clients"))
    private Client client;

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", region='" + region + '\'' +
                ", district='" + district + '\'' +
                ", city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", house='" + house + '\'' +
                ", client=" + client +
                '}';
    }
}
