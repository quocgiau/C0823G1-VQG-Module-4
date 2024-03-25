package com.example.demo_chuong_lon.service;

import com.example.demo_chuong_lon.model.Cage;
import com.example.demo_chuong_lon.repository.ICageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CageService implements ICageService{
    @Autowired
    private ICageRepository iCageRepository;
    @Override
    public Page<Cage> getList(Pageable pageable) {
        return iCageRepository.findAll(pageable);
    }

    @Override
    public void save(Cage cage) {
        iCageRepository.save(cage);
    }

    @Override
    public Cage findById(int id) {
        return iCageRepository.findById(id).get();
    }

    @Override
    public void delete(Cage cage) {
        iCageRepository.delete(cage);
    }

    @Override
    public Page<Cage> findByNameContaining(String name, Pageable pageable) {
        return iCageRepository.findByNameContaining(name, pageable);
    }
}
