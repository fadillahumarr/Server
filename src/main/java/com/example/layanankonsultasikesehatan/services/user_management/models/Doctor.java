package com.example.layanankonsultasikesehatan.services.user_management.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "dokter")
public class Doctor {
    @Id
    private int id_dokter;
    private String nama_dokter;
    private String spesialis;
    private String alamat_dokter;
    private int biaya_konsultasi;


    public int getId_dokter() {
        return id_dokter;
    }
    public void setId_dokter(int id_dokter) {
        this.id_dokter = id_dokter;
    }

    public String getNama_dokter() {
        return nama_dokter;
    }

    public void setNama_dokter(String nama_dokter) {
        this.nama_dokter = nama_dokter;
    }

    public String getSpesialis() {
        return spesialis;
    }

    public void setSpesialis(String spesialis) {
        this.spesialis = spesialis;
    }

    public String getAlamat_dokter() {
        return alamat_dokter;
    }

    public void setAlamat_dokter(String alamat_dokter) {
        this.alamat_dokter = alamat_dokter;
    }

    public int getBiaya_konsultasi() {
        return biaya_konsultasi;
    }

    public void setBiaya_konsultasi(int biaya_konsultasi) {
        this.biaya_konsultasi = biaya_konsultasi;
    }
}
