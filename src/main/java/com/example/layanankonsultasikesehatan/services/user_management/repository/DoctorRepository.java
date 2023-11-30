package com.example.layanankonsultasikesehatan.services.user_management.repository;

import com.example.layanankonsultasikesehatan.services.user_management.models.Doctor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

//Spring Data JPA untuk operasi CRUD
@Repository
public interface DoctorRepository extends CrudRepository<Doctor,Integer> {
    @Query(value = "SELECT * FROM dokter WHERE id_dokter = :id_dokter", nativeQuery = true)
    Doctor findDoctorById(@Param("id_dokter") int id_dokter);

    @Query(value = "SELECT * FROM dokter", nativeQuery = true)
    List<Doctor> findAllDokter();
}
