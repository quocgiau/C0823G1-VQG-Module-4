package com.example.borrow_books.repository;

import com.example.borrow_books.model.CodeBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICodeRepository extends JpaRepository<CodeBook, Integer> {
}
