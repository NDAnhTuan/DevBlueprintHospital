package com.devteria.scheduling.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.devteria.scheduling.dto.ApiResponse;
import com.devteria.scheduling.dto.request.AppointmentRequest;
import com.devteria.scheduling.dto.response.AppointmentResponse;
import com.devteria.scheduling.service.AppointmentService;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

@RestController
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequestMapping("/appointment")
public class AppointmentController {
    AppointmentService appointmentService;

    // Create a new appointment
    @PostMapping
    ApiResponse<AppointmentResponse> createAppointment(@RequestBody AppointmentRequest request) {
        return ApiResponse.<AppointmentResponse>builder()
                .result(appointmentService.createAppointment(request))
                .build();
    }

    // Get an appointment by doctorId or patientId
    @GetMapping
    ApiResponse<List<AppointmentResponse>> getMyAppointments(
            @RequestParam(required = false) String doctorId, @RequestParam(required = false) String patientId) {

        return ApiResponse.<List<AppointmentResponse>>builder()
                .result(appointmentService.getMyAppointments(doctorId, patientId))
                .build();
    }

    @PutMapping("/update/{appointmentId}")
    ApiResponse<AppointmentResponse> updateAppointment(
            @PathVariable String appointmentId, @RequestBody AppointmentRequest request) {
        return ApiResponse.<AppointmentResponse>builder()
                .result(appointmentService.updateAppointment(appointmentId, request))
                .build();
    }

    // Cancel an appointment
    @PutMapping("/cancel/{appointmentId}")
    ApiResponse<String> cancelAppointment(@PathVariable String appointmentId) {
        appointmentService.cancelAppointment(appointmentId);
        return ApiResponse.<String>builder()
                .result("Appointment cancelled successfully")
                .build();
    }
}
