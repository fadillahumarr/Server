package com.example.layanankonsultasikesehatan.services.user_management.repository;

import com.example.layanankonsultasikesehatan.services.user_management.models.Jadwal;
import com.example.layanankonsultasikesehatan.services.user_management.models.User;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

@Repository
public interface JadwalRepository extends CrudRepository<Jadwal,Integer> {

    @Modifying
    @Query(value = "INSERT INTO jadwal (id_dokter, tanggal_konsultasi, waktu_konsultasi) VALUES (:id_dokter, :tanggal_konsultasi, :waktu_konsultasi)", nativeQuery = true)
    int jadwalKonsultasi(@Param("id_dokter") int id_dokter, @Param("tanggal_konsultasi") LocalDate tanggal_konsultasi, @Param("waktu_konsultasi") LocalTime waktu_konsultasi);
}
