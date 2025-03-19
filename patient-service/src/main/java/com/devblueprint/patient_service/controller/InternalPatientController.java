package com.devblueprint.patient_service.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.devblueprint.patient_service.dto.ApiResponse;
import com.devblueprint.patient_service.dto.request.PatientCreationRequest;
import com.devblueprint.patient_service.dto.response.PatientResponse;
import com.devblueprint.patient_service.service.PatientService;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

@RestController
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
// Controller cho các api không public
public class InternalPatientController {
    PatientService patientService;

    @PostMapping("/internal/patient")
    ApiResponse<PatientResponse> createPatient(@RequestBody PatientCreationRequest request) {
        return ApiResponse.<PatientResponse>builder()
                .result(patientService.createPatient(request))
                .build();
    }
}
