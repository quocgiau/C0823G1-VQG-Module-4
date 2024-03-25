package com.example.validation.controller;

import com.example.validation.dto.UserDTO;
import com.example.validation.model.User;
import com.example.validation.service.IUserService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class UserController {
    @Autowired
    IUserService userService;

    @GetMapping("")
    public String show(Model model) {
        UserDTO userDTO = new UserDTO();
        model.addAttribute("user", userDTO);
        return "/views";
    }

    @PostMapping("")
    public String save(@Valid @ModelAttribute("user") UserDTO userDTO, BindingResult bindingResult, Model model) {
        User user1 = new User();
        new UserDTO().validate(userDTO, bindingResult);
        if (bindingResult.hasFieldErrors()) {
            return "views";
        }
        BeanUtils.copyProperties(userDTO, user1);
        userService.add(user1);
        model.addAttribute("name", userDTO.getFirst());
        model.addAttribute("email", userDTO.getEmail());
        return "result";
    }
}
