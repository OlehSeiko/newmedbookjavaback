package com.example.demo.services.Impl;

import com.example.demo.dao.PatientDAO;
import com.example.demo.entity.Patient;
import com.example.demo.services.PatientServices;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class PatientServiceImpl implements PatientServices {
    private PatientDAO patientDAO;

    @Override
    public void save(Patient patient) {
        if(patient != null) {
            patientDAO.save(patient);
        }
    }

    @Override
    public List<Patient> findAll() {
        return patientDAO.findAll();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return patientDAO.findByUsername(username);
    }

    public Patient findByUserName(String username) {
        return patientDAO.findByUsername(username);
    }

    @Override
    public Patient findById(int id) {
        return patientDAO.findById(id).get();
    }
}
