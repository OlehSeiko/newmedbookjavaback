package com.example.demo.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@RestController
public class PhotoController {

    @PostMapping("/save/photo")
    public String savePhoto(@RequestParam("photo") MultipartFile file) throws IOException {
        System.out.println(file.getOriginalFilename());
        String path = System.getProperty("user.dir") + File.separator

                + "target" + File.separator
                + "classes" + File.separator
                + "static" + File.separator
                + "images" + File.separator;
        file.transferTo(new File(path + file.getOriginalFilename()));
        return "save ok";
    }
}
