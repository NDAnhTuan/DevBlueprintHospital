package com.devteria.scheduling.controller;

import com.devteria.scheduling.dto.ApiResponse;
import com.devteria.scheduling.dto.response.UserProfileResponse;
import com.devteria.scheduling.service.DoctorService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("internal/doctors")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)

public class InternalDoctorController {
    DoctorService doctorService;
    @GetMapping("/check-id")
    ApiResponse<Boolean> getProfile(@PathVariable String doctorId) {
        return ApiResponse.<Boolean>builder()
                .result(doctorService.checkId(doctorId))
                .build();
    }
}
