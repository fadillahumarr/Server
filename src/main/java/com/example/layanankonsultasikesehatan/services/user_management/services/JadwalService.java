package com.example.layanankonsultasikesehatan.services.user_management.services;

import com.example.layanankonsultasikesehatan.services.user_management.models.Jadwal;
import com.example.layanankonsultasikesehatan.services.user_management.repository.JadwalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JadwalService {
    @Autowired
    private JadwalRepository jadwalRepository;

    public Jadwal simpanJadwalKonsultasi(Jadwal jadwalKonsultasi) {
        return jadwalRepository.save(jadwalKonsultasi);
    }
}
