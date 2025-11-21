package com.venky.service;




import org.springframework.stereotype.Service;

import com.venky.entity.ContactMessage;
import com.venky.repository.ContactRepository;

@Service
public class ContactService {

    private final ContactRepository repo;

    public ContactService(ContactRepository repo) {
        this.repo = repo;
    }

    public ContactMessage save(ContactMessage msg) {
        return repo.save(msg);
    }
}

