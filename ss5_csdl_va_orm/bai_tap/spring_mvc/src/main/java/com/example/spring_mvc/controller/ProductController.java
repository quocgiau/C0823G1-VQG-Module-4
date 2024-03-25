package com.example.spring_mvc.controller;

import com.example.spring_mvc.model.Product;
import com.example.spring_mvc.service.IProductService;
import com.example.spring_mvc.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ProductController {
    private static final IProductService service = new ProductService();

    @GetMapping("")
    public String display(Model model) {
        List<Product> products = service.findAll();
        model.addAttribute("products", products);
        return "/views";
    }

//    @PostMapping("/delete")
//    public String delete(Product product) {
//        service.remove(product.getId());
//        return "redirect:/";
//    }
//
    @GetMapping("/create")
    public String createForm(Model model) {
        model.addAttribute("product", new Product());
        return "/create";
    }
//
//    @PostMapping("/create")
//    public String create(Product product, Model model) {
//        try {
//            product.setId(inputId());
//            service.add(product);
//            return "redirect:/";
//        } catch (Exception e) {
//            model.addAttribute("name", product.getName());
//            model.addAttribute("price", product.getPrice());
//            model.addAttribute("describe", product.getDescribe());
//            model.addAttribute("producer", product.getProducer());
//            return "/create";
//        }
//    }
//    @GetMapping("/{id}/edit")
//    public String editForm(@PathVariable int id, Model model){
//        model.addAttribute("product", service.findById(id));
//        return "/update";
//    }
//    @PostMapping("/edit")
//    public String edit(Product product){
//        service.update(product.getId(), product);
//         return "redirect:/";
//    }
//    public int inputId() {
//        int count = 0;
//        List<Product> productList = service.findAll();
//        for (Product product : productList) {
//            count = product.getId();
//        }
//        return count + 1;
//    }
}
