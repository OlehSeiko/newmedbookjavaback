package com.example.demo.dao;

import com.example.demo.entity.Laboratory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LaboratoryDAO extends JpaRepository<Laboratory, Integer> {
    Laboratory findByUsername(String username);
}
