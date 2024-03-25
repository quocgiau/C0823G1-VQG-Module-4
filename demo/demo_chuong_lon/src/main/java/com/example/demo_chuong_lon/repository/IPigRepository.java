package com.example.demo_chuong_lon.repository;

import com.example.demo_chuong_lon.model.Pig;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IPigRepository extends JpaRepository<Pig,Integer> {
    @Query(value = "SELECT * FROM pig WHERE cage_id = :cageId", nativeQuery = true)
    Page<Pig> findAllPigsByCageId(@Param("cageId") int cageId, Pageable pageable);
    Page<Pig> findByNameContaining(String name, Pageable pageable);
}
