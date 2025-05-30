package com.portfolio.devansh.Service;

import com.portfolio.devansh.DTO.ContactForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    public void sendContactEmail(ContactForm form) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("your_email@gmail.com");
        message.setTo("your_email@gmail.com"); // your inbox
        message.setSubject("New Contact Form Submission");

        message.setText(
                "Name: " + form.getFirstName() + " " + form.getLastName() + "\n" +
                        "Email: " + form.getEmail() + "\n" +
                        "Phone: " + form.getPhone() + "\n\n" +
                        "Message:\n" + form.getMessage()
        );

        mailSender.send(message);
    }
}

