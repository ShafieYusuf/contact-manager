package com.example.contact.maneger.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String phone_number;
    private String email;
    private String address;
}
