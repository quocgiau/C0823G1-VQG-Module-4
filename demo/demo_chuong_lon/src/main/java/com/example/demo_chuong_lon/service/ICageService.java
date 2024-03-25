package com.example.demo_chuong_lon.service;

import com.example.demo_chuong_lon.model.Cage;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ICageService {
    Page<Cage> getList(Pageable pageable);
    void save(Cage cage);
    Cage findById(int id);
    void delete(Cage cage);
    Page<Cage> findByNameContaining(String name, Pageable pageable);
}
