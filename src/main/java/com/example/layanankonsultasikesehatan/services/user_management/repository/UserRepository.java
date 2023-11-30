package com.example.layanankonsultasikesehatan.services.user_management.repository;

import com.example.layanankonsultasikesehatan.services.user_management.models.User;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository <User,Integer> {

    @Query(value = "SELECT email FROM pengguna WHERE email = :email", nativeQuery = true)
    List<String> checkUserEmail(@Param("email")String email);

    @Query(value = "SELECT kata_sandi FROM pengguna WHERE email = :email", nativeQuery = true)
    String checkUserPasswordByEmail(@Param("email")String email);

    @Query(value = "SELECT * FROM pengguna WHERE email = :email", nativeQuery = true)
    User getUserDetailsByEmail(@Param("email")String email);
    @Transactional
    @Modifying
    @Query(value = "INSERT INTO pengguna (nama_lengkap, jenis_kelamin, tanggal_lahir, alamat, nomor_hp, email, kata_sandi) VALUES (:nama_lengkap, :jenis_kelamin, :tanggal_lahir, :alamat, :nomor_hp, :email, :kata_sandi)", nativeQuery = true)
    int registerNewUser(@Param("nama_lengkap")String nama_lengkap,
                        @Param("jenis_kelamin")String jenis_kelamin,
                        @Param("tanggal_lahir")String tanggal_lahir,
                        @Param("alamat") String alamat,
                        @Param("nomor_hp")String nomor_hp,
                        @Param("email")String email,
                        @Param("kata_sandi")String kata_sandi);
}
