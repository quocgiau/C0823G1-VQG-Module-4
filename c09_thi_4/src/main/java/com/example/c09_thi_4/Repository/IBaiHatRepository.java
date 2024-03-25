package com.example.c09_thi_4.Repository;

import com.example.c09_thi_4.Model.BaiHat;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IBaiHatRepository extends JpaRepository<BaiHat,Integer> {
//    @Query(value = "SELECT * FROM bai_hat WHERE ten_bai IS NULL OR ten_bai = ?", nativeQuery = true)
    Page<BaiHat> findByTenBaiContaining(String name, Pageable pageable);
    Page<BaiHat> findByTacGiaContaining(String card, Pageable pageable);
    Page<BaiHat> findByTenBaiContainingAndTacGiaContaining(String name, String card, Pageable pageable);
}
