package com.example.spring_mvc.repository;

import com.example.spring_mvc.model.Product;

import java.util.List;

public interface IProductRepository {
    List<Product> findAll();

    void add(Product customer);

    Product findById(int id);

    void update(int id, Product customer);

    void remove(int id);
}
