package com.example.ss14.service;

import com.example.ss14.model.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;

import java.util.List;

public interface IStudentService {
    List<Student> getAll();

    void save(Student student);

    Student getStudentById(int id);

    Page<Student> getAll(Pageable pageable);

}
