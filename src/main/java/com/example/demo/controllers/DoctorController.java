package com.example.demo.controllers;

import com.example.demo.entity.Doctor;
import com.example.demo.entity.Patient;
import com.example.demo.entity.Speciality;
import com.example.demo.services.DoctorService;
import com.example.demo.services.PatientServices;
import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class DoctorController {

    private DoctorService doctorService;

    private PasswordEncoder passwordEncoder;

    private PatientServices patientServices;

    @GetMapping("/speciality")
    public Speciality [] getSpeciality(){
        System.out.println(Speciality.values());
        return Speciality.values();
    }

    @PostMapping("/save/doctor")
    public String saveDoctor(@RequestBody Doctor doctor) {
        doctor.setPassword(passwordEncoder.encode(doctor.getPassword()));
        System.out.println(doctor);
        doctorService.save(doctor);
        return "DOCTOR";
    }
    
    @GetMapping("/doctor/potochnuy")
    public Doctor doctorPotochnuy(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String name = authentication.getName();
        Doctor doctor = doctorService.findByUserName(name);
        return doctor;
    }

    @GetMapping("/doctor/patient/{id}")
    public Patient doctorPatientId(@PathVariable int id){
        return patientServices.findById(id);
    }
}
