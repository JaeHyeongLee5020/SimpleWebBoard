package com.mid20192158.bbs.repository;

import com.mid20192158.bbs.entity.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository extends JpaRepository<Contact, String> {
}
