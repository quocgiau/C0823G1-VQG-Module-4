package com.example.ss14.controller;

import com.example.ss14.model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import java.util.List;

@Controller
public class StudentTalkController {

    @GetMapping("/list-talk")
    public String listTalk(Model model, @SessionAttribute("studentTalkList") List<Student> studentTalkList) {
        model.addAttribute("listStudent", studentTalkList);
        return "list_talk";
    }
}
