package com.example.layanankonsultasikesehatan.services.user_management.services;

import com.example.layanankonsultasikesehatan.services.user_management.models.Consultation;
import com.example.layanankonsultasikesehatan.services.user_management.repository.ConsultationRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConsultationService {

    @Autowired
    private ConsultationRepository consultationRepository;

    public List<Consultation> getAllConsultations() {
        return consultationRepository.findAll();
    }

    public Consultation getConsultationById(int id) {
        return consultationRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Consultation not found with id: " + id));
    }

    public Consultation saveConsultation(Consultation consultation) {
        return consultationRepository.save(consultation);
    }

    public Consultation updateConsultation(int id, Consultation consultation) {
        Consultation existingConsultation = getConsultationById(id);
        // Update the existingConsultation with the new data from the input consultation
        existingConsultation.setPengguna(consultation.getPengguna());
        existingConsultation.setDokter(consultation.getDokter());
        existingConsultation.setKeluhan(consultation.getKeluhan());
        return consultationRepository.save(existingConsultation);
    }

    public void deleteConsultation(int id) {
        consultationRepository.deleteById(id);
    }
}
