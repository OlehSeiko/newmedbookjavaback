package com.example.demo.services;

import com.example.demo.entity.Doctor;
import com.example.demo.entity.Laboratory;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface LaboratoryService extends UserDetailsService {
    void save(Laboratory laboratory);

    List<Laboratory> findAll();

    Laboratory findByUserName(String username);
}
