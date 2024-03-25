package com.example.ss14.repository;

import com.example.ss14.model.ClassRoom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IClassRepository extends JpaRepository<ClassRoom, Integer> {
}
