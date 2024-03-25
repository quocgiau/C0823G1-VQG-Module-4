package com.example.ss14.service.impl;

import com.example.ss14.dto.UserInfoUserDetails;
import com.example.ss14.model.AppUser;
import com.example.ss14.model.UserRole;
import com.example.ss14.repository.IUserRepository;
import com.example.ss14.repository.IUserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserInforDetailService implements UserDetailsService {
    @Autowired
    private IUserRepository iUserRepository;

    @Autowired
    private IUserRoleRepository iUserRoleRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUser appUser = iUserRepository.findByUserName(username);
        List<UserRole> userRoles = iUserRoleRepository.findAllByAppUser(appUser);
        UserInfoUserDetails infoUserDetails = new UserInfoUserDetails(appUser, userRoles);
        return infoUserDetails;
    }
}
