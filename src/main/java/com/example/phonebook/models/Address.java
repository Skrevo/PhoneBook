package com.example.phonebook.models;

import lombok.*;

import javax.persistence.*;

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
    @JoinColumn(foreignKey = @ForeignKey(name = "FK_address_contacts"))
    private Contact contact;

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", region='" + region + '\'' +
                ", district='" + district + '\'' +
                ", city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", house='" + house + '\'' +
                ", contact=" + contact +
                '}';
    }
}
