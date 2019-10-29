package com.example.demo.services;

import com.example.demo.dao.DoctorDAO;
import com.example.demo.entity.Doctor;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;


public interface DoctorService extends UserDetailsService {
     void save(Doctor doctor);

     List<Doctor> findAll();

    Doctor findByUserName(String username);
}
