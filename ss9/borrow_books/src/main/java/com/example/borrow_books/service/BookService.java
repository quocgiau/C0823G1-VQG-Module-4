package com.example.borrow_books.service;

import com.example.borrow_books.model.Book;
import com.example.borrow_books.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService implements IBookService {
    @Autowired
    private BookRepository iBookRepository;

    @Override
    public void save(Book book) {
        iBookRepository.save(book);
    }

    @Override
    public Book findById(int id) {
        return iBookRepository.findById(id).get();
    }

    @Override
    public void delete(Book book) {
        iBookRepository.delete(book);
    }

    @Override
    public List<Book> getList() {
        return iBookRepository.findAll();
    }
}
