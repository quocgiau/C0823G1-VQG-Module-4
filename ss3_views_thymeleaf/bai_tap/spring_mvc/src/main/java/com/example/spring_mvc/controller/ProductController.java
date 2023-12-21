package com.example.spring_mvc.controller;

import com.example.spring_mvc.model.Product;
import com.example.spring_mvc.service.IProductService;
import com.example.spring_mvc.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ProductController {
    private static final IProductService service = new ProductService();
    @GetMapping("")
    public String display(Model model){
        List<Product> products = service.findAll();
        model.addAttribute("products", products);
        return "/views";
    }
    @PostMapping("/delete")
    public String delete(Product product){
        service.remove(product.getId());
        return "/views";
    }
}
