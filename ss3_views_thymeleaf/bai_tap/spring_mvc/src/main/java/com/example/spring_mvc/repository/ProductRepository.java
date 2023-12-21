package com.example.spring_mvc.repository;

import com.example.spring_mvc.model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ProductRepository implements IProductRepository {
    private static final Map<Integer, Product> hashMap = new HashMap<>();

    static {
        hashMap.put(1,new Product(1, "Dầu", 10, "Chất lỏng màu đen", "Nhà máy"));
        hashMap.put(2,new Product(2, "Lúa", 10, "Thức ăn", "Ruông"));
        hashMap.put(3,new Product(3, "Sắt", 12, "Kim loại", "Hầm mỏ"));
        hashMap.put(4,new Product(4, "Đất", 15, "Tài nguyên", "Nhà máy"));
        hashMap.put(5,new Product(5, "Khoáng", 20, "Kim loại quý", "Núi lửa"));
    }

    @Override
    public List<Product> findAll() {
        List<Product> list = new ArrayList<>(hashMap.values());
        return list;
    }

    @Override
    public void add(Product customer) {

    }

    @Override
    public Product findById(int id) {
        return null;
    }

    @Override
    public void update(int id, Product customer) {

    }

    @Override
    public void remove(int id) {
        hashMap.remove(id);
    }
}
