package com.devblueprint.patient_service.controller;

import java.util.List;

import com.devblueprint.patient_service.dto.request.PatientCreationRequest;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping()
    ApiResponse<List<PatientResponse>> getAllPatients() {
        return ApiResponse.<List<PatientResponse>>builder()
                .result(patientService.getAllPatients())
                .build();
    }
    @GetMapping("/{id}")
    ApiResponse<PatientResponse> getPatient(@PathVariable String id) {
        return ApiResponse.<PatientResponse>builder()
                .result(patientService.getPatient(id))
                .build();
    }

    @PostMapping()
    ApiResponse<PatientResponse> createPatient(@RequestBody PatientCreationRequest request) {
        return ApiResponse.<PatientResponse>builder()
                .result(patientService.createPatient(request))
                .build();
    }



}
