package com.example.spring_mvc.service;

import com.example.spring_mvc.model.Blog;

import java.util.List;

public interface IBlogService {
    List<Blog> findAll();
    void add(Blog blog);
    Blog findById(int id);
    void edit(int id, Blog blog);
    void remove(int id);
}
