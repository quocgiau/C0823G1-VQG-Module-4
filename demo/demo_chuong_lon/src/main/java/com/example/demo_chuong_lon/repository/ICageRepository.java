package com.example.demo_chuong_lon.repository;

import com.example.demo_chuong_lon.model.Cage;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICageRepository extends JpaRepository<Cage, Integer> {
    Page<Cage> findByNameContaining(String name, Pageable pageable);
}
