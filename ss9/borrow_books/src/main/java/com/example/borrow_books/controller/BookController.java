package com.example.borrow_books.controller;

import com.example.borrow_books.model.Book;
import com.example.borrow_books.model.CodeBook;
import com.example.borrow_books.service.IBookService;
import com.example.borrow_books.service.ICodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class BookController {
    @Autowired
    private IBookService iBookService;
    @Autowired
    private ICodeService iCodeService;

    @GetMapping()
    private String home(Model model) {
        model.addAttribute("book", iBookService.getList());
        return "views";
    }

    @GetMapping("/detail/{id}")
    public String showDetail(@PathVariable int id, Model model) {
        Book book = iBookService.findById(id);
        model.addAttribute("book", book);
        return "detail";
    }

    @GetMapping("/addBook")
    private String formAdd(Model model) {
        model.addAttribute("book", new Book());
        return "add";
    }

    @GetMapping("add")
    private String add(Book book) {
        iBookService.save(book);
        return "redirect:/";
    }

    @GetMapping("/borrow")
    public String borrow(@ModelAttribute Book book, Model model) {
        if (book.getQuantity() <= 0) {
            model.addAttribute("mess", 2);
            return "error";
        }
        book.setQuantity(book.getQuantity() - 1);
        iBookService.save(book);
        int id = iCodeService.generateId();
        CodeBook codeBook = new CodeBook(id, book);
        iCodeService.save(codeBook);
        model.addAttribute("id", id);
        return "borrow";
    }


    @GetMapping("search")
    private String search(@RequestParam int quantity, Model model) {
        try {
            CodeBook codeBook = iCodeService.findById(quantity);
            Book book = iBookService.findById(codeBook.getBook().getId());
            book.setQuantity(book.getQuantity() + 2);
            iBookService.save(book);
            iCodeService.delete(codeBook.getId());
            return "redirect:/";
        } catch (Exception e) {
            model.addAttribute("mess", 1);
            return "views";
        }

    }

    @ExceptionHandler(Exception.class)
    private String getError() {
        return "error";
    }
}
