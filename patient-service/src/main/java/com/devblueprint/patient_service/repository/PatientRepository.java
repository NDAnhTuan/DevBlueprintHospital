package com.devblueprint.patient_service.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.devblueprint.patient_service.entity.Patient;

@Repository
public interface PatientRepository extends JpaRepository<Patient, String> {
    @Override
    Optional<Patient> findById(String id);
}
