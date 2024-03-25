package com.example.ss14.service.impl;

import com.example.ss14.model.ClassRoom;
import com.example.ss14.repository.IClassRepository;
import com.example.ss14.service.IClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassService implements IClassService {
    @Autowired
    private IClassRepository iClassRepository;

    @Override
    public List<ClassRoom> findAll() {
        return iClassRepository.findAll();
    }
}
