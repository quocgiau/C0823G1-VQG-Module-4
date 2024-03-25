package com.example.ss14.repository;

import com.example.ss14.model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface IUserRepository extends JpaRepository<AppUser, Long> {

    AppUser findByUserName(String username);
}
