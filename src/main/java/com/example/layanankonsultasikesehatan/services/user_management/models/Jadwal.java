package com.example.layanankonsultasikesehatan.services.user_management.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.antlr.v4.runtime.misc.NotNull;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

@Entity
@Table(name = "jadwal")
public class Jadwal {

    @Id
    private int id_jadwal;

    private String id_dokter;
    private LocalDate tanggal_konsultasi;
    private LocalTime waktu_konsultasi;

    public int getId_jadwal() {
        return id_jadwal;
    }

    public void setId_jadwal(int id_jadwal) {
        this.id_jadwal = id_jadwal;
    }

    public String getId_dokter() {
        return id_dokter;
    }

    public void setId_dokter(String id_dokter) {
        this.id_dokter = id_dokter;
    }

    public LocalDate getTanggal_konsultasi() {
        return tanggal_konsultasi;
    }

    public void setTanggal_konsultasi(LocalDate tanggal_konsultasi) {
        this.tanggal_konsultasi = tanggal_konsultasi;
    }

    public LocalTime getWaktu_konsultasi() {
        return waktu_konsultasi;
    }

    public void setWaktu_konsultasi(LocalTime waktu_konsultasi) {
        this.waktu_konsultasi = waktu_konsultasi;
    }
}
