package com.example.contact.maneger.Repository;

import com.example.contact.maneger.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface ContactRepositery extends JpaRepository<Contact, Long> {

}