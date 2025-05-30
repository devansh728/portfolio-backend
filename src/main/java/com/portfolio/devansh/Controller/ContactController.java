package com.portfolio.devansh.Controller;

import com.portfolio.devansh.DTO.ContactForm;
import com.portfolio.devansh.Service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/contact")
@CrossOrigin(origins = "*") // allow frontend calls
public class ContactController {

    @Autowired
    private EmailService emailService;

    @PostMapping
    public ResponseEntity<?> handleContact(@RequestBody ContactForm form) {
        try {
            emailService.sendContactEmail(form);
            return ResponseEntity.ok().body("{\"code\":200, \"message\":\"Message sent successfully\"}");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("{\"code\":500, \"message\":\"Failed to send message\"}");
        }
    }
}

