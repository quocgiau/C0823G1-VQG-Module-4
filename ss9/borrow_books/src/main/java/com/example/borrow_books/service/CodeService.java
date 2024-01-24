package com.example.borrow_books.service;

import com.example.borrow_books.model.CodeBook;
import com.example.borrow_books.repository.ICodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CodeService implements ICodeService{
    @Autowired
    private ICodeRepository iCodeRepository;
    @Override
    public int generateId() {
        return (int) (Math.floor(Math.random() * 99999) + 10000);
    }

    @Override
    public CodeBook findById(int id) {
        return iCodeRepository.findById(id).get();
    }

    @Override
    public void save(CodeBook codeBook) {
        iCodeRepository.save(codeBook);
    }

    @Override
    public void delete(int id) {
        iCodeRepository.deleteById(id);
    }
}
