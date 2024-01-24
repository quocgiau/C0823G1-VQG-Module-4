package com.example.borrow_books.service;


import com.example.borrow_books.model.Book;

import java.util.List;

public interface IBookService {
    void save(Book book);

    Book findById(int id);

    void delete(Book book);

    List<Book> getList();
}
