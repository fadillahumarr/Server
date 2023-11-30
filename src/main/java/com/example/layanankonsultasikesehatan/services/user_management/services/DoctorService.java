package com.example.layanankonsultasikesehatan.services.user_management.services;

import com.example.layanankonsultasikesehatan.services.user_management.models.Doctor;
import com.example.layanankonsultasikesehatan.services.user_management.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorService {
    @Autowired
    DoctorRepository itemRepository;

    public List<Doctor> getAllDokter() {
        return itemRepository.findAllDokter();
    }

    public Doctor getDoctorById(int id_dokter) {
        return itemRepository.findDoctorById(id_dokter);
    }
}
