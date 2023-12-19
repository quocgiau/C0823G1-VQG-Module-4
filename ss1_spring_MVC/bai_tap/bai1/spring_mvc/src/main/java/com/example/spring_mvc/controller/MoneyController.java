package com.example.spring_mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class MoneyController {
    @GetMapping("")
    public String display(){
        return "/views";
    }
    @GetMapping("/convert")
    public String convert(@RequestParam double price, Model model) {
        double result = 23000 * price;
        model.addAttribute("result", result);
        return "/views";
    }
}
