package com.mid20192158.bbs.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Contact {

    @Id
    private String id;

    private String name;
    
    private String phone;
    private String email;
    private String address;

    private LocalDateTime createdDate;
    
}
