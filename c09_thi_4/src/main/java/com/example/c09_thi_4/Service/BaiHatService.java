package com.example.c09_thi_4.Service;

import com.example.c09_thi_4.Model.BaiHat;
import com.example.c09_thi_4.Repository.IBaiHatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BaiHatService implements IBaiHatService{
    @Autowired
    private IBaiHatRepository repository;
    @Override
    public List<BaiHat> findAll() {
        return repository.findAll();
    }

    @Override
    public BaiHat findById(int id) {
        return repository.findById(id).get();
    }

    @Override
    public void save(BaiHat baiHat) {
        repository.save(baiHat);
    }

    @Override
    public Page<BaiHat> getList(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public void delete(BaiHat baiHat) {
        repository.delete(baiHat);
    }

    @Override
    public Page<BaiHat> findByNameContaining(String name, Pageable pageable) {
        return repository.findByTenBaiContaining(name, pageable);
    }

    @Override
    public Page<BaiHat> findByCardContaining(String card, Pageable pageable) {
        return repository.findByTacGiaContaining(card, pageable);
    }

    @Override
    public Page<BaiHat> findByNameContainingAndCardContaining(String name, String card, Pageable pageable) {
        return repository.findByTenBaiContainingAndTacGiaContaining(name, card, pageable);
    }
}
