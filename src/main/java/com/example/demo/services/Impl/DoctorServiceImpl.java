package com.example.demo.services.Impl;

import com.example.demo.dao.DoctorDAO;
import com.example.demo.entity.Doctor;
import com.example.demo.services.DoctorService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class DoctorServiceImpl implements DoctorService {

    private DoctorDAO doctorDAO;

    @Override
    public void save(Doctor doctor) {
        if(doctor != null) {
            doctorDAO.save(doctor);
        }
    }

    @Override
    public List<Doctor> findAll() {
        return doctorDAO.findAll();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return doctorDAO.findByUsername(username);
    }
    public Doctor findByUserName(String username) {
        return doctorDAO.findByUsername(username);
    }
}
