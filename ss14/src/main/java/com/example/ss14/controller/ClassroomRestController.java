package com.example.ss14.controller;

import com.example.ss14.model.ClassRoom;
import com.example.ss14.service.IClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/classroom")
@CrossOrigin("*")
public class ClassroomRestController {

    @Autowired
    private IClassService iClassService;

    @GetMapping("")
    public List<ClassRoom> getList() {
        System.out.println("abc");
        return iClassService.findAll();
    }
}
