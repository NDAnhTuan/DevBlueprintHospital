package com.devblueprint.patient_service.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.devblueprint.patient_service.dto.ApiResponse;
import com.devblueprint.patient_service.dto.response.PatientResponse;
import com.devblueprint.patient_service.service.PatientService;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

@RestController
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class PatientController {
    PatientService patientService;

    @GetMapping("/patient/{id}")
    ApiResponse<PatientResponse> getPatient(@PathVariable String id) {
        return ApiResponse.<PatientResponse>builder()
                .result(patientService.getPatient(id))
                .build();
    }

    @GetMapping("/patient")
    ApiResponse<List<PatientResponse>> getAllPatients() {
        return ApiResponse.<List<PatientResponse>>builder()
                .result(patientService.getAllPatients())
                .build();
    }

    @GetMapping("/patient/my-patient")
    ApiResponse<List<PatientResponse>> getMyPatient() {
        return ApiResponse.<List<PatientResponse>>builder()
                .result(patientService.getMyPatient())
                .build();
    }
}
