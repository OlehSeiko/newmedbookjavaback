package com.example.demo.controllers;

import com.example.demo.entity.Laboratory;
import com.example.demo.services.LaboratoryService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class LaboratoryController {

    private LaboratoryService laboratoryService;

    private PasswordEncoder passwordEncoder;
    
    @PostMapping("/save/laboratory")
    public String saveLaboratory(@RequestBody Laboratory laboratory){
        laboratory.setPassword(passwordEncoder.encode(laboratory.getPassword()));
        this.laboratoryService.save(laboratory);
        return "Laboratory";
    }
    
    @GetMapping("/laboratory/potochnuy")
    public Laboratory laboratoryPotochnuy(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String name = authentication.getName();

        Laboratory laboratory = laboratoryService.findByUserName(name);
        return laboratory;
    }
}
