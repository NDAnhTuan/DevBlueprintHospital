package com.devteria.swagger.mapper;

import org.springframework.stereotype.Component;

import com.devteria.swagger.dto.response.AppointmentResponse;
import com.devteria.swagger.entity.Appointment;
import com.devteria.swagger.repository.httpCilent.DoctorService;
import com.devteria.swagger.repository.httpCilent.PatientService;

@Component
public class AppointmentResponseMapper {

    private final DoctorService doctorService;
    private final PatientService patientService;

    public AppointmentResponseMapper(DoctorService doctorService, PatientService patientService) {
        this.doctorService = doctorService;
        this.patientService = patientService;
    }

    public AppointmentResponse toAppointmentResponse(
            Appointment appointment, PatientService patientService, DoctorService doctorService) {
        AppointmentResponse response = new AppointmentResponse();
        response.setId(appointment.getId());
        response.setPatient(patientService.getPatientResponse(appointment.getPatientId()));
        response.setDoctor(doctorService.getDoctorResponse(appointment.getDoctorId()));
        response.setAppointmentDateTime(appointment.getAppointmentDateTime());
        response.setReason(appointment.getReason());
        response.setStatus(appointment.getStatus());
        return response;
    }
}
