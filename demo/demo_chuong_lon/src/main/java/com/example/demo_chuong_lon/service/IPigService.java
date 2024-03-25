package com.example.demo_chuong_lon.service;

import com.example.demo_chuong_lon.model.Pig;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IPigService {
    Page<Pig> getListPrivate(int id, Pageable pageable);

    Page<Pig> getList(Pageable pageable);

    void save(Pig pig);

    Pig findById(int id);

    void delete(Pig pig);

    Page<Pig> findByNameContaining(String name, Pageable pageable);
}
