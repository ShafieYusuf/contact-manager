package com.example.contact.maneger.Controler;

import com.example.contact.maneger.Service.ContactService;
import com.example.contact.maneger.model.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
@RequestMapping("/contacts")
public class ContactController {
    private final ContactService contactService;

    @Autowired
    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    @GetMapping
    public String getAllContact(Model model) {
        List<Contact> contacts = contactService.getAllContacts();
        model.addAttribute("contacts", contacts);
        return "contacts";
    }

    @GetMapping("/{id}")
    public String getContactById(@PathVariable Long id, Model model) {
        Contact contact = contactService.getContactById(id);
        model.addAttribute("contact", contact);
        return "contact-details";
    }

    @GetMapping("/new")
    public String showContactForm(Model model) {
        model.addAttribute("contact", new Contact());
        return "contact-form";
    }

    @PostMapping("/new")
    public String saveContact(@ModelAttribute("contact") Contact contact) {
        contactService.saveContact(contact);
        return "redirect:/contacts";

    }
    @GetMapping("/{id}/edit")
    public String showEditForm(@PathVariable Long id, Model model) {
        Contact contact = contactService.getContactById(id);
        model.addAttribute("contact", contact);
        return "contact-form";
    }

    @PostMapping("/{id}/edit")
    public String updateContact(@ModelAttribute("contact") Contact contact) {
        contactService.saveContact(contact);
        return "redirect:/contacts";
    }

    @GetMapping("/{id}/delete")
    public String deleteContact(@PathVariable Long id) {
        contactService.deleteContact(id);
        return "redirect:/contacts";
    }

}