package com.example.c09_thi_4.Service;

import com.example.c09_thi_4.Model.TheLoai;
import com.example.c09_thi_4.Repository.ITheLoaiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TheLoaiService implements ITheLoaiService{
    @Autowired
    private ITheLoaiRepository repository;
    @Override
    public List<TheLoai> getAll() {
        return repository.findAll();
    }
}
