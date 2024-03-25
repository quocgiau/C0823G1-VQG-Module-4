package com.example.demo_chuong_lon.controller;

import com.example.demo_chuong_lon.model.Pig;
import com.example.demo_chuong_lon.service.IPigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("pig")
public class PigController {
    @Autowired
    private IPigService iPigService;
    @GetMapping("/{id}")
    public String showPig(@PageableDefault(value = 3) Pageable pageable, Model model, @PathVariable int id) {
        Page<Pig> pigs = iPigService.getListPrivate(id, pageable);
        model.addAttribute("pigPrivate", pigs);
        return "list_pig_private";
    }
    @GetMapping("")
    public String show(@PageableDefault(value = 3)Pageable pageable, Model model){
        Page<Pig> pigs = iPigService.getList(pageable);
        model.addAttribute("pig", pigs);
        return "list_pig";
    }
}
