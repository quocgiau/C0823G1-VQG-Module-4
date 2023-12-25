package com.example.spring_mvc.repository;


import com.example.spring_mvc.model.Product;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class ProductRepository implements IProductRepository {
    private static EntityManager entityManager;
    private static SessionFactory sessionFactory;

    static {
        try {
            sessionFactory = new Configuration()
                    .configure("hibernate.conf.xml")
                    .buildSessionFactory();
            entityManager = sessionFactory.createEntityManager();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public List<Product> findAll() {
        String query = "select p from Product p";
        TypedQuery<Product> typedQuery = entityManager.createQuery(query, Product.class);
        return typedQuery.getResultList();
    }
//
//    @Override
//    public void add(Product product) {
//        hashMap.put(product.getId(),product);
//    }
//
//    @Override
//    public Product findById(int id) {
//        return hashMap.get(id);
//    }
//
//    @Override
//    public void update(int id, Product product) {
//        hashMap.put(id, product);
//    }
//
//    @Override
//    public void remove(int id) {
//        hashMap.remove(id);
//    }
}
