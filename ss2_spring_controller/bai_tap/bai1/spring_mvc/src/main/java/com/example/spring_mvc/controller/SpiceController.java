package com.example.spring_mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class SpiceController {
    @GetMapping("")
    public String display(){
        return "/views";
    }
    @PostMapping("condiments")
    public String condiments(@RequestParam(value = "sort", defaultValue = "Empty list") String[] sort, Model model){
        model.addAttribute("sort", sort);
        return "/result";
    }
}
