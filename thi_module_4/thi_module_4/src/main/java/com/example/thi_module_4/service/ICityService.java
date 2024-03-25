package com.example.thi_module_4.service;

import com.example.thi_module_4.model.City;

import java.util.List;

public interface ICityService {
    List<City> findAll();

    void save(City city);

    City findById(Long id);


    void delete(City city);
}
