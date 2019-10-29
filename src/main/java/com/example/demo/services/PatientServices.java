package com.example.demo.services;

import com.example.demo.entity.Patient;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface PatientServices extends UserDetailsService {
    void save(Patient patient);

    List<Patient> findAll();

    Patient findByUserName(String username);

    Patient findById(int id);
}
