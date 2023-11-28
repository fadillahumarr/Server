package com.example.layanankonsultasikesehatan.services.user_management.rest_controllers;

import com.example.layanankonsultasikesehatan.services.user_management.models.Doctor;
import com.example.layanankonsultasikesehatan.services.user_management.services.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/dokter")
public class DoctorApiController {

    @Autowired
    DoctorService itemService;

    @GetMapping
    public List<Doctor> getAllDokter() {
        return itemService.getAllDokter();
    }
}
