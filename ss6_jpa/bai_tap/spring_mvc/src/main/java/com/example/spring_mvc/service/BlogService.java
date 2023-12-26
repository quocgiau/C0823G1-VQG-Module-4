package com.example.spring_mvc.service;

import com.example.spring_mvc.model.Blog;
import com.example.spring_mvc.repository.BlogRepository;
import com.example.spring_mvc.repository.IBlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BlogService implements IBlogService {

    @Autowired
    private IBlogRepository blogRepository;

    @Override
    public List<Blog> findAll() {
        return blogRepository.findAll();
    }

    @Override
    public void add(Blog blog) {
        blogRepository.add(blog);
    }

    @Override
    public Blog findById(int id) {
        return blogRepository.findById(id);
    }

    @Override
    public void edit(int id, Blog blog) {
        blogRepository.edit(id, blog);
    }

    @Override
    public void remove(int id) {
        blogRepository.remove(id);
    }
}
