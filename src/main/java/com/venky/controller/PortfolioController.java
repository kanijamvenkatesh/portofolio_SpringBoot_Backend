package com.venky.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.venky.entity.ContactMessage;
import com.venky.service.ContactService;

@RestController
@RequestMapping("/portfolio")
@CrossOrigin(origins = {
		"https://portfolio-frontend-1-zzgd.onrender.com",
    "http://localhost:3000"
    
})
public class PortfolioController {

    private final ContactService service;

    public PortfolioController(ContactService service) {
        this.service = service;
    }

    @PostMapping("/contact")
    public ResponseEntity<String> saveMessage(@RequestBody ContactMessage form) {
        service.save(form);
        return ResponseEntity.ok("Message received");
    }

    @GetMapping("/about")
    public String about() {
        return "I am a Full Stack Developer (Java + React)...";
    }

    @GetMapping("/skills")
    public String[] skills() {
        return new String[]{
            "HTML", "CSS", "JavaScript", "ReactJS", "Core Java",
            "J2EE", "JSP", "Servlets", "Spring Core",
            "Spring Boot", "Microservices Architecture",
            "API Gateway", "Service Registry",
            "Git", "GitHub", "Cloud Basics"
        };
    }

    @GetMapping("/projects")
    public String[] projects() {
        return new String[]{
            "Employee CRUD App",
            "JWT Login App",
            "Mini E-Commerce",
            "Portfolio Website"
        };
    }
}

