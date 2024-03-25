package com.example.demo_email.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MailController {
    @Autowired
    JavaMailSender javaMailSender;

    @GetMapping("")
    public String show() {
        return "FormSendMail";
    }

    @PostMapping("/send")
    public String sendMail(@RequestParam(value = "to") String to,
                           @RequestParam(value = "subject") String subject,
                           @RequestParam(value = "content") String content) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject(subject);
        message.setText(content);
        javaMailSender.send(message);
        return "result";
    }
} 
