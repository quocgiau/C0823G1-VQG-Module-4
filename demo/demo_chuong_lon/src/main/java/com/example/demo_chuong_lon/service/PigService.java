package com.example.demo_chuong_lon.service;

import com.example.demo_chuong_lon.model.Pig;
import com.example.demo_chuong_lon.repository.IPigRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class PigService implements IPigService {
    @Autowired
    private IPigRepository iPigRepository;

    @Override
    public Page<Pig> getListPrivate(int id, Pageable pageable) {
        return iPigRepository.findAllPigsByCageId(id, pageable);
    }

    @Override
    public Page<Pig> getList(Pageable pageable) {
        return iPigRepository.findAll(pageable);
    }

    @Override
    public void save(Pig pig) {
        iPigRepository.save(pig);
    }

    @Override
    public Pig findById(int id) {
        return iPigRepository.findById(id).get();
    }

    @Override
    public void delete(Pig pig) {
        iPigRepository.delete(pig);
    }

    @Override
    public Page<Pig> findByNameContaining(String name, Pageable pageable) {
        return iPigRepository.findByNameContaining(name, pageable);
    }
}
