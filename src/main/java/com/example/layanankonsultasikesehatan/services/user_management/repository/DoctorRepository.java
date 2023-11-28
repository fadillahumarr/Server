package com.example.layanankonsultasikesehatan.services.user_management.repository;

import com.example.layanankonsultasikesehatan.services.user_management.models.Doctor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DoctorRepository extends CrudRepository<Doctor,Integer> {
    @Query(value = "SELECT * FROM dokter", nativeQuery = true)
    List<Doctor> findAllDokter();
}
