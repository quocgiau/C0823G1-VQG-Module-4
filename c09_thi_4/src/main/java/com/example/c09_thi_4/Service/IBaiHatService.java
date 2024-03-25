package com.example.c09_thi_4.Service;

import com.example.c09_thi_4.Model.BaiHat;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IBaiHatService {
    List<BaiHat> findAll();

    BaiHat findById(int id);

    void save(BaiHat baiHat);
    Page<BaiHat> getList(Pageable pageable);

    void delete(BaiHat baiHat);

    Page<BaiHat> findByNameContaining(String name, Pageable pageable);
    Page<BaiHat> findByCardContaining(String card, Pageable pageable);
    Page<BaiHat> findByNameContainingAndCardContaining(String name, String card, Pageable pageable);
}
