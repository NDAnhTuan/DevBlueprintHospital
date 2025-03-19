package com.devblueprint.patient_service.service;

import java.util.List;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.devblueprint.patient_service.dto.request.PatientCreationRequest;
import com.devblueprint.patient_service.dto.response.PatientResponse;
import com.devblueprint.patient_service.entity.Patient;
import com.devblueprint.patient_service.exception.AppException;
import com.devblueprint.patient_service.exception.ErrorCode;
import com.devblueprint.patient_service.mapper.PatientMapper;
import com.devblueprint.patient_service.repository.PatientRepository;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class PatientService {
    PatientRepository patientRepository;
    PatientMapper patientMapper;

    public PatientResponse createPatient(PatientCreationRequest request) {
        var authentication = SecurityContextHolder.getContext().getAuthentication();
        String userId = authentication.getName();
        Patient patient = patientMapper.toPatient(request);
        patient.setUserId(userId);
        try {
            patient = patientRepository.save(patient);
        }
        catch (DataIntegrityViolationException exception) {
            throw new AppException(ErrorCode.PATIENT_EXISTED);
        }
        return patientMapper.toPatientResponse(patient);
    }

    public PatientResponse getPatient(String id) {
        Patient patient = patientRepository.findById(id).orElseThrow(() -> new AppException(ErrorCode.PATIENT_NOT_EXISTED));

        return patientMapper.toPatientResponse(patient);
    }

    public List<PatientResponse> getAllPatients() {
        var patients = patientRepository.findAll();

        return patients.stream().map(patientMapper::toPatientResponse).toList();
    }

    public List<PatientResponse> getMyPatient() {
        var authentication = SecurityContextHolder.getContext().getAuthentication();
        String userId = authentication.getName();

        var patients =
                patientRepository.findAllByUserId(userId);
        return patients.stream().map(patientMapper::toPatientResponse).toList();
    }
}
