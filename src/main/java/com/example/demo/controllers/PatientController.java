package com.example.demo.controllers;

import com.example.demo.dao.DoctorDAO;
import com.example.demo.entity.Doctor;
import com.example.demo.entity.Patient;
import com.example.demo.entity.Speciality;
import com.example.demo.services.DoctorService;
import com.example.demo.services.PatientServices;
import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
public class PatientController {
    private PatientServices patientServices;

    private DoctorService doctorService;

    private PasswordEncoder passwordEncoder;

    @PostMapping("/save/patient")
    public void savePatient(@RequestBody Patient patient){
        System.out.println("PM in back");
        patient.setPassword(passwordEncoder.encode(patient.getPassword()));
       patientServices.save(patient);
    }

    @GetMapping("/patient/potochnuy")
    public Patient patientPotochnuy(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String name = authentication.getName();
        Patient patient = patientServices.findByUserName(name);
        System.out.println(patient);
        return patient;
    }
    @GetMapping("/patient/doctor/{speciality}")
    public List<Doctor> getDoctor(@PathVariable String speciality){
        System.out.println("----Speciality-----");
        System.out.println(speciality);
        System.out.println("----Speciality-----");
        List<Doctor> all = doctorService.findAll();
        System.out.println("-----BCI-----");
        for (Doctor doctor : all) {
            System.out.println(doctor);
        }
        System.out.println("-----BCI-----");
        System.out.println(Speciality.ХІРУРГ);

        List<Doctor> filteredDoctors = new ArrayList<>();
        for (Doctor doctor : all) {
            if (String.valueOf(doctor.getSpeciality()).equals(speciality)){
                filteredDoctors.add(doctor);
            }
        }
        System.out.println(filteredDoctors);
        return filteredDoctors;
    }
}
