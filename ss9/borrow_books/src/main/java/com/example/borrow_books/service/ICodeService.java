package com.example.borrow_books.service;

import com.example.borrow_books.model.CodeBook;

public interface ICodeService {
    int generateId();

    CodeBook findById(int id);

    void save(CodeBook codeBook);

    void delete(int id);
}
