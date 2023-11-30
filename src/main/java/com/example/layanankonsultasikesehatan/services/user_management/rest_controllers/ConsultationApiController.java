package com.example.layanankonsultasikesehatan.services.user_management.rest_controllers;

import com.example.layanankonsultasikesehatan.services.user_management.models.Consultation;
import com.example.layanankonsultasikesehatan.services.user_management.services.ConsultationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/consultations")
public class ConsultationApiController {

        @Autowired
        private ConsultationService consultationService;

        @PostMapping
        public ResponseEntity<Consultation> addConsultation(@RequestBody Consultation consultation) {
                Consultation savedConsultation = consultationService.saveConsultation(consultation);
                return new ResponseEntity<>(savedConsultation, HttpStatus.CREATED);
        }

}
