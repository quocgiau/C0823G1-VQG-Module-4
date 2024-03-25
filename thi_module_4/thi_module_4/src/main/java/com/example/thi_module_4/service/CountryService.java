package com.example.thi_module_4.service;

import com.example.thi_module_4.model.City;
import com.example.thi_module_4.model.Country;
import com.example.thi_module_4.repository.ICountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryService implements ICountryService{
    @Autowired
    private ICountryRepository countryRepository;
    @Override
    public List<Country> findAll() {
        return countryRepository.findAll();
    }
}
