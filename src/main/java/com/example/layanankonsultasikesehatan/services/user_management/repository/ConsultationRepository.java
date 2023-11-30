package com.example.layanankonsultasikesehatan.services.user_management.repository;

import com.example.layanankonsultasikesehatan.services.user_management.models.Consultation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConsultationRepository extends JpaRepository<Consultation, Integer> {

}
