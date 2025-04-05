package com.devteria.doctor_service.service;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import jakarta.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.devteria.doctor_service.dto.request.AppointmentRequest;
import com.devteria.doctor_service.dto.response.AppointmentResponse;
import com.devteria.doctor_service.entity.Appointment;
import com.devteria.doctor_service.exception.AppException;
import com.devteria.doctor_service.exception.ErrorCode;
import com.devteria.doctor_service.mapper.AppointmentMapper;
import com.devteria.doctor_service.repository.AppointmentRepository;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class AppointmentService {
    AppointmentRepository appointmentRepository;
    AppointmentMapper appointmentMapper;

    // Validate the appointment time range, must be from 07:00 to 16:00
    private void validateAppointmentTime(LocalDateTime appointmentDateTime) {
        // Skip validation if it is null
        if (appointmentDateTime == null) {
            return;
        }

        LocalTime start = LocalTime.of(7, 0);
        LocalTime end = LocalTime.of(16, 0);
        LocalTime appointmentTime = appointmentDateTime.toLocalTime();

        if (appointmentTime.isBefore(start) || appointmentTime.isAfter(end)) {
            throw new AppException(ErrorCode.APPOINTMENT_TIME_INVALID);
        }
    }

    // Create a new appointment
    public AppointmentResponse createAppointment(AppointmentRequest request) {
        if (request.getAppointmentDateTime() == null) {
            request.setAppointmentDateTime(LocalDateTime.now());
        }

        // Validate the time range
        validateAppointmentTime(request.getAppointmentDateTime());

        // Check if the doctor has an appointment within 1 hour of the requested time
        boolean conflict = appointmentRepository.existsByDoctorIdAndTimeConflict(
                request.getDoctorId(), request.getAppointmentDateTime());

        if (conflict) {
            throw new AppException(ErrorCode.APPOINTMENT_NOT_AVAILABLE);
        }

        Appointment appointment = appointmentMapper.toAppointment(request);
        appointment.setStatus("PENDING");

        return appointmentMapper.toAppointmentResponse(appointmentRepository.save(appointment));
    }

    // Update an existing appointment
    @Transactional
    public AppointmentResponse updateAppointment(String id, AppointmentRequest request) {
        Appointment appointment =
                appointmentRepository.findById(id).orElseThrow(() -> new AppException(ErrorCode.APPOINTMENT_NOT_FOUND));

        // If the appointmentDateTime is not null, validate the time
        if (request.getAppointmentDateTime() != null) {
            // Validate the time range
            validateAppointmentTime(request.getAppointmentDateTime());

            // Check if the doctor has an appointment within 1 hour of the requested time
            boolean conflict = appointmentRepository.existsByDoctorIdAndTimeConflict(
                    request.getDoctorId(), request.getAppointmentDateTime());

            if (conflict && !appointment.getAppointmentDateTime().equals(request.getAppointmentDateTime())) {
                throw new AppException(ErrorCode.APPOINTMENT_NOT_AVAILABLE);
            }
        }

        // Use the Mapper
        appointmentMapper.updateAppointment(appointment, request);

        Appointment updated = appointmentRepository.save(appointment);
        return appointmentMapper.toAppointmentResponse(updated);
    }

    // Get an appointment by doctor or patient
    public List<AppointmentResponse> getMyAppointments(String doctorId, String patientId) {
        if (doctorId == null && patientId == null) {
            throw new AppException(ErrorCode.INVALID_REQUEST);
        }

        List<Appointment> appointments;

        if (doctorId != null) {
            appointments = appointmentRepository.findAllByDoctorId(doctorId);
        } else {
            appointments = appointmentRepository.findAllByPatientId(patientId);
        }

        return appointments.stream()
                .map(appointmentMapper::toAppointmentResponse)
                .toList();
    }

    // Cancel an appointment
    public AppointmentResponse cancelAppointment(String appointmentId) {
        Appointment appointment = appointmentRepository
                .findById(appointmentId)
                .orElseThrow(() -> new AppException(ErrorCode.APPOINTMENT_NOT_FOUND));
        appointment.setStatus("CANCELLED");
        appointment = appointmentRepository.save(appointment);

        return appointmentMapper.toAppointmentResponse(appointment);
    }
}
