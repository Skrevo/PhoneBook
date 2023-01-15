package com.example.phonebook.models;


import lombok.*;

import javax.persistence.*;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "phones")
public class Phone {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false, length = 20)
    private String phone;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "contact_id", nullable = false,
            foreignKey = @ForeignKey(name = "FK_phones_contacts"))
    private Contact contact;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Phone phone1 = (Phone) o;
        return Objects.equals(id, phone1.id) && Objects.equals(phone, phone1.phone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, phone);
    }

    @Override
    public String toString() {
        return  phone;
    }
}
