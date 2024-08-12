package com.example.contact.maneger.Service;
import com.example.contact.maneger.model.Contact;
import com.example.contact.maneger.Repository.ContactRepositery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactService {
    private final ContactRepositery contactRepository;

    @Autowired
    public ContactService(ContactRepositery contactRepositery) {
        this.contactRepository = contactRepositery;
    }

    public List<Contact> getAllContacts() {return contactRepository.findAll();
    }

    public Contact getContactById(Long id) {
        return contactRepository.findById(id).orElse(null);
    }

    public void saveContact(Contact contact) {
        contactRepository.save(contact);
    }

    public void deleteContact(Long id) {
        contactRepository.deleteById(id);
    }
}