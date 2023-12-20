package com.example.spring_mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ComputerController {
    @GetMapping("")
    public String display() {
        return "/views";
    }

    @PostMapping("calculate")
    public String calculate(@RequestParam(defaultValue = "0") Long before,
                            @RequestParam(defaultValue = "0") Long after,
                            @RequestParam(defaultValue = "") String subtend,
                            Model model) {
        String result = "";
        switch (subtend) {
            case "add":
                result = String.valueOf(before + after);
                break;
            case "sub":
                result = String.valueOf(before - after);
                break;
            case "core":
                result = String.valueOf(before * after);
                break;
            case "divide":
                if (after == 0) {
                    result = "The code must be different from 0";
                } else {
                    result = String.valueOf(before / after);
                }
                break;
        }
        model.addAttribute("result", result);
        return "/views";
    }
}
