package com.venky.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.venky.entity.ContactMessage;
import com.venky.service.ContactService;

@RestController
@RequestMapping("/portfolio")
@CrossOrigin(origins = {
    "http://localhost:3000",
    "https://your-frontend.onrender.com"
})
public class PortfolioController {

    private final ContactService service;

    public PortfolioController(ContactService service) {
        this.service = service;
    }

    // Correct path
    @PostMapping("/contact")
    public ResponseEntity<String> saveMessage(@RequestBody ContactMessage form) {
        service.save(form);  // save to DB
        return ResponseEntity.ok("Message received");
    }

    @GetMapping("/about")
    public String about() {
        return "I am a Full Stack Developer (Java + React)...";
    }
}


