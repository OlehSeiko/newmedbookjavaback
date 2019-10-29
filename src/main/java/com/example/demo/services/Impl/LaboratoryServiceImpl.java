package com.example.demo.services.Impl;

import com.example.demo.dao.LaboratoryDAO;
import com.example.demo.entity.Doctor;
import com.example.demo.entity.Laboratory;
import com.example.demo.services.LaboratoryService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class LaboratoryServiceImpl implements LaboratoryService {

    private LaboratoryDAO laboratoryDAO;

    @Override
    public void save(Laboratory laboratory) {
        if (laboratory != null) {
            laboratoryDAO.save(laboratory);
        }

    }

    @Override
    public List<Laboratory> findAll() {
        return laboratoryDAO.findAll();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return laboratoryDAO.findByUsername(username);
    }

    public Laboratory findByUserName(String username) {return laboratoryDAO.findByUsername(username);
    }
}
