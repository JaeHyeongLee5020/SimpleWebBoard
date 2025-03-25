package com.mid20192158.bbs.service;

import com.mid20192158.bbs.entity.Contact;
import com.mid20192158.bbs.repository.ContactRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ContactService {

    private final ContactRepository contactRepository;

    public List<Contact> findAllContacts() {
        return contactRepository.findAll();
    }

    public Contact findContactById(String id) {
        Optional<Contact> contact = contactRepository.findById(id);
        return contact.orElse(null);
    }

    public void saveContact(Contact contact) {
        contactRepository.save(contact);
    }

    public void updateContact(Contact contact) {
        contactRepository.save(contact);
    }

    public void deleteContact(String id) {
        contactRepository.deleteById(id);
    }
}
