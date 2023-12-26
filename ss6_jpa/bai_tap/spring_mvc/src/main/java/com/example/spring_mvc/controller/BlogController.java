package com.example.spring_mvc.controller;

import com.example.spring_mvc.model.Blog;
import com.example.spring_mvc.service.BlogService;
import com.example.spring_mvc.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
@Controller
public class BlogController {
    @Autowired
    private IBlogService service;
    @GetMapping("")
    public String display(Model model) {
        List<Blog> blogs = service.findAll();
        model.addAttribute("blogs", blogs);
        return "/views";
    }

}
