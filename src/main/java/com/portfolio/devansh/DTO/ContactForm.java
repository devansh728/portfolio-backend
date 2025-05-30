package com.portfolio.devansh.DTO;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ContactForm {
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String message;

    // Getters and setters
}

