package com.venky.controller;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.venky.entity.ContactMessage;
import com.venky.service.ContactService;

import java.util.List;

@RestController
@RequestMapping("/portfolio")
@CrossOrigin
public class PortfolioController {

    private final ContactService service;

    public PortfolioController(ContactService service) {
        this.service = service;
    }

    // 1. Contact form submission
    @PostMapping("/contact")
    public ContactMessage saveMessage(@RequestBody ContactMessage msg) {
        return service.save(msg);
    }

    // 2. Skills list
    @GetMapping("/skills")
    public List<String> skills() {
        return List.of("Java", "Spring Boot", "ReactJS", "MySQL", "Docker");
    }

    // 3. Projects list
    @GetMapping("/projects")
    public List<String> projects() {
        return List.of(
                "Employee CRUD App",
                "JWT Login App",
                "Mini E-Commerce",
                "Portfolio Website"
        );
    }
    @PostMapping("/portfolio/contact")
    public ResponseEntity<String> saveMessage1(@RequestBody ContactMessage form) {
        // save form to DB or send email
        return ResponseEntity.ok("Message received");
    }

    // 4. About info
    @GetMapping("/about")
    public String about() {
        return "I am a Full Stack Developer (Java + React) with experience in building real applications.";
    }
    
}

