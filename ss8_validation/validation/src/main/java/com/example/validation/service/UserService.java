package com.example.validation.service;

import com.example.validation.model.User;
import com.example.validation.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService{
    @Autowired
    IUserRepository userRepository;
    @Override
    public void add(User user) {
        userRepository.save(user);
    }
}
