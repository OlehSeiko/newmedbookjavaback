package com.example.demo.dao;

import com.example.demo.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorDAO extends JpaRepository<Doctor,Integer> {
    Doctor findByUsername(String username);
}
