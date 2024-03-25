package com.example.demo_chuong_lon.controller;

import com.example.demo_chuong_lon.DTO.CageDTO;
import com.example.demo_chuong_lon.model.Cage;
import com.example.demo_chuong_lon.service.ICageService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class CageController {
    @Autowired
    private ICageService iCageService;

    @GetMapping("")
    public String showCage(@PageableDefault(value = 3) Pageable pageable, Model model) {
        Page<Cage> cages = iCageService.getList(pageable);
        model.addAttribute("cage", cages);
        return "list_cage";
    }

    @GetMapping("add")
    public String showFormAdd(Model model) {
        model.addAttribute("cage", new CageDTO());
        return "add_cage";
    }

    @PostMapping("add")
    public String addCage(@Valid @ModelAttribute("cage") CageDTO cageDTO,
                          BindingResult bindingResult, Model model, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasFieldErrors()){
            model.addAttribute("cage", cageDTO);
            return "add_cage";
        }
        Cage cage = new Cage();
        BeanUtils.copyProperties(cageDTO, cage);
        iCageService.save(cage);
        redirectAttributes.addFlashAttribute("message", 1);
        return "redirect:/";
    }
    @PostMapping("delete")
    public String delete(@RequestParam("id") int id){
        Cage cage = iCageService.findById(id);
        iCageService.delete(cage);
        return "redirect:/";
    }
    @PostMapping("search")
    public String search(@RequestParam("nameSearch") String name,
                         @PageableDefault(value = 3) Pageable pageable, Model model){
        Page<Cage> cages = iCageService.findByNameContaining(name, pageable);
        model.addAttribute("cage", cages);
        return "list_cage";
    }
    @ExceptionHandler(Exception.class)
    public String ha(){
        return "er";
    }
}
