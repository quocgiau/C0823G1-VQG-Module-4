package com.example.spring_mvc.service;

import com.example.spring_mvc.model.Blog;
import com.example.spring_mvc.repository.BlogRepository;
import com.example.spring_mvc.repository.IBlogRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BlogService implements IBlogService {
    private static IBlogRepository repository = new BlogRepository();

    @Override
    public List<Blog> findAll() {
        return repository.findAll();
    }

    @Override
    public void add(Blog blog) {
        repository.add(blog);
    }

    @Override
    public Blog findById(int id) {
        return repository.findById(id);
    }

    @Override
    public void edit(int id, Blog blog) {
        repository.edit(id, blog);
    }

    @Override
    public void remove(int id) {
        repository.remove(id);
    }
}
