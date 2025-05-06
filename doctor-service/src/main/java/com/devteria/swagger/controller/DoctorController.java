package com.devteria.swagger.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.devteria.swagger.dto.ApiResponse;
import com.devteria.swagger.dto.request.DoctorCreationRequest;
import com.devteria.swagger.dto.response.DoctorCreationResponse;
import com.devteria.swagger.service.DoctorService;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

@RestController
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class DoctorController {
    DoctorService doctorService;

    @PostMapping
    ApiResponse<DoctorCreationResponse> createDoctor(@RequestBody DoctorCreationRequest request) {
        return ApiResponse.<DoctorCreationResponse>builder()
                .result(doctorService.createDoctor(request))
                .build();
    }

    @GetMapping("/{id}")
    ApiResponse<DoctorCreationResponse> getDoctor(@PathVariable String id) {
        return ApiResponse.<DoctorCreationResponse>builder()
                .result(doctorService.getDoctor(id))
                .build();
    }

    @GetMapping
    ApiResponse<List<DoctorCreationResponse>> getAllDoctors() {
        return ApiResponse.<List<DoctorCreationResponse>>builder()
                .result(doctorService.getAllDoctors())
                .build();
    }

    @PutMapping("/{id}")
    ApiResponse<DoctorCreationResponse> updateDoctor(
            @PathVariable String id, @RequestBody DoctorCreationRequest request) {
        return ApiResponse.<DoctorCreationResponse>builder()
                .result(doctorService.updateDoctor(id, request))
                .build();
    }

    @DeleteMapping("/{id}")
    ApiResponse<Void> deleteDoctor(@PathVariable String id) {
        doctorService.deleteDoctor(id);
        return ApiResponse.<Void>builder().build();
    }
}
