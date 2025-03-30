package com.devteria.scheduling.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.devteria.scheduling.dto.ApiResponse;
import com.devteria.scheduling.dto.request.AppointmentRequest;
import com.devteria.scheduling.dto.response.AppointmentResponse;
import com.devteria.scheduling.service.AppointmentService;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

@RestController
@RequestMapping("/internal")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class InternalAppointmentController {
    private final AppointmentService appointmentService;

    @PostMapping("/appointment")
    ApiResponse<AppointmentResponse> createAppointment(@RequestBody AppointmentRequest request) {
        return ApiResponse.<AppointmentResponse>builder()
                .result(appointmentService.createAppointment(request))
                .build();
    }

    @GetMapping("/appointment")
    ApiResponse<List<AppointmentResponse>> getMyAppointments(
            @RequestParam(required = false) String doctorId, @RequestParam(required = false) String patientId) {

        return ApiResponse.<List<AppointmentResponse>>builder()
                .result(appointmentService.getMyAppointments(doctorId, patientId))
                .build();
    }

    @PutMapping("/appointment/{appointmentId}")
    ApiResponse<String> cancelAppointment(@PathVariable String appointmentId) {
        appointmentService.cancelAppointment(appointmentId);
        return ApiResponse.<String>builder()
                .result("Appointment cancelled successfully")
                .build();
    }

    @PutMapping("/update/{appointmentId}")
    ApiResponse<AppointmentResponse> updateAppointment(
            @PathVariable String appointmentId, @RequestBody AppointmentRequest request) {
        return ApiResponse.<AppointmentResponse>builder()
                .result(appointmentService.updateAppointment(appointmentId, request))
                .build();
    }
}
