package com.example.layanankonsultasikesehatan.services.user_management.rest_controllers;

import com.example.layanankonsultasikesehatan.services.user_management.models.Jadwal;
import com.example.layanankonsultasikesehatan.services.user_management.services.JadwalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

@RestController
@RequestMapping("/api/jadwal_konsultasi")
public class JadwalApiController {


        @Autowired
        private JadwalService jadwalService;


    @PostMapping("/simpan")
    public ResponseEntity<String> simpanJadwalKonsultasi(
            @RequestParam String id_dokter,
            @RequestParam @DateTimeFormat(pattern = "dd-MM-yyyy") String tanggal_konsultasi,
            @RequestParam @DateTimeFormat(pattern = "HH:mm") String waktu_konsultasi) {
        try {
            LocalDate parsedDate = LocalDate.parse(tanggal_konsultasi, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
            LocalTime parsedTime = LocalTime.parse(waktu_konsultasi, DateTimeFormatter.ofPattern("HH:mm"));

            Jadwal jadwal = new Jadwal();
            jadwal.setId_dokter(id_dokter);
            jadwal.setTanggal_konsultasi(parsedDate);
            jadwal.setWaktu_konsultasi(parsedTime);

            jadwalService.simpanJadwalKonsultasi(jadwal);

            return ResponseEntity.ok("Jadwal konsultasi berhasil disimpan");
        } catch (DateTimeParseException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Format data dan waktu tidak valid");
        }
    }



}
