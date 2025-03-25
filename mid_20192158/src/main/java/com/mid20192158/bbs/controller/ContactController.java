package com.mid20192158.bbs.controller;

import com.mid20192158.bbs.entity.Contact;
import com.mid20192158.bbs.service.ContactService;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@Controller
public class ContactController {

    private final ContactService contactService;

    @RequestMapping("/")
    public String root() {
        return "index";
    }

    @GetMapping("/contacts")
    public String listContacts(Model model) {
        model.addAttribute("contacts", contactService.findAllContacts());
        return "contact-list";
    }

    @GetMapping("/contacts/new")
    public String showCreateForm(Model model) {
        model.addAttribute("contact", new Contact());
        return "create-contact";
    }

    @PostMapping("/contacts")
    public String createContact(@ModelAttribute Contact contact) {
        contact.setCreatedDate(LocalDateTime.now()); 
        contactService.saveContact(contact);
        return "redirect:/contacts";
    }


    @GetMapping("/contacts/{id}")
    public String viewContact(@PathVariable("id") String id, Model model) {
        model.addAttribute("contact", contactService.findContactById(id));
        return "view-contact";
    }

    @GetMapping("/contacts/{id}/edit")
    public String showEditForm(@PathVariable("id") String id, Model model) {
        model.addAttribute("contact", contactService.findContactById(id));
        return "edit-contact";
    }

    @PostMapping("/contacts/{id}")
    public String updateContact(@PathVariable("id") String id, @ModelAttribute Contact contact) {
        Contact existingContact = contactService.findContactById(id);
        
        if (existingContact != null) {
            existingContact.setName(contact.getName());
            existingContact.setPhone(contact.getPhone());
            existingContact.setEmail(contact.getEmail());
            existingContact.setAddress(contact.getAddress());
            contactService.saveContact(existingContact);
        }

        return "redirect:/contacts";
    }
}
