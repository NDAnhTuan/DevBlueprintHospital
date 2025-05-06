package com.devblueprint.patient_service.controller;

import org.springframework.web.bind.annotation.*;

import com.devblueprint.patient_service.dto.ApiResponse;
import com.devblueprint.patient_service.dto.request.PatientCreationRequest;
import com.devblueprint.patient_service.dto.response.PatientResponse;
import com.devblueprint.patient_service.service.PatientService;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

@RestController
@RequestMapping("/internal")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
// Controller cho các api không public
public class InternalPatientController {
    PatientService patientService;

    @GetMapping("/{id}")
    ApiResponse<PatientResponse> getPatient(@PathVariable String id) {
        return ApiResponse.<PatientResponse>builder()
                .result(patientService.getPatient(id))
                .build();
    }

    @PostMapping("")
    ApiResponse<PatientResponse> createPatient(@RequestBody PatientCreationRequest request) {
        return ApiResponse.<PatientResponse>builder()
                .result(patientService.createPatient(request))
                .build();
    }

    @GetMapping("/check-id")
    ApiResponse<Boolean> checkExistingPatient(@PathVariable String patientId) {
        return ApiResponse.<Boolean>builder()
                .result(patientService.checkId(patientId))
                .build();
    }
}
