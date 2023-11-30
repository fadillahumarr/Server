package com.example.layanankonsultasikesehatan.services.user_management.models;

import jakarta.persistence.*;

@Entity
@Table(name = "konsultasi")
public class Consultation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idKonsultasi;


    @ManyToOne
    @JoinColumn(name = "id_pengguna", nullable = false)
    private User pengguna;

    @ManyToOne
    @JoinColumn(name = "id_dokter", nullable = false)
    private Doctor dokter;

    private String keluhan;

    public int getIdKonsultasi() {
        return idKonsultasi;
    }

    public void setIdKonsultasi(int idKonsultasi) {
        this.idKonsultasi = idKonsultasi;
    }

    public User getPengguna() {
        return pengguna;
    }

    public void setPengguna(User pengguna) {
        this.pengguna = pengguna;
    }

    public Doctor getDokter() {
        return dokter;
    }

    public void setDokter(Doctor dokter) {
        this.dokter = dokter;
    }

    public String getKeluhan() {
        return keluhan;
    }

    public void setKeluhan(String keluhan) {
        this.keluhan = keluhan;
    }
}
