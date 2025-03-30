package com.devteria.scheduling.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.devteria.scheduling.dto.request.AppointmentRequest;
import com.devteria.scheduling.dto.response.AppointmentResponse;
import com.devteria.scheduling.entity.Appointment;
import com.devteria.scheduling.exception.AppException;
import com.devteria.scheduling.exception.ErrorCode;
import com.devteria.scheduling.mapper.AppointmentMapper;
import com.devteria.scheduling.repository.AppointmentRepository;

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

    // Create a new appointment
    public AppointmentResponse createAppointment(AppointmentRequest request) {
        boolean conflict = appointmentRepository.existsByDoctorIdAndTimeConflict(
                request.getDoctorId(), request.getAppointmentDateTime());

        if (conflict) {
            throw new AppException(ErrorCode.APPOINTMENT_NOT_AVAILABLE);
        }

        Appointment appointment = appointmentMapper.toAppointment(request);
        appointment.setStatus("SCHEDULED");

        return appointmentMapper.toAppointmentResponse(appointmentRepository.save(appointment));
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
