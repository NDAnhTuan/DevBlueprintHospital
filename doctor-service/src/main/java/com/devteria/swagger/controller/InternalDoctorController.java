package com.devteria.swagger.controller;

import com.devteria.swagger.dto.response.DoctorCreationResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devteria.swagger.dto.ApiResponse;
import com.devteria.swagger.service.DoctorService;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

@RestController
@RequestMapping("/internal")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class InternalDoctorController {
    DoctorService doctorService;

    @GetMapping("/{id}")
    ApiResponse<DoctorCreationResponse> getDoctor(@PathVariable String id) {
        return ApiResponse.<DoctorCreationResponse>builder()
                .result(doctorService.getDoctor(id))
                .build();
    }
    @GetMapping("/check-id")
    ApiResponse<Boolean> getProfile(@PathVariable String doctorId) {
        return ApiResponse.<Boolean>builder()
                .result(doctorService.checkId(doctorId))
                .build();
    }
}
