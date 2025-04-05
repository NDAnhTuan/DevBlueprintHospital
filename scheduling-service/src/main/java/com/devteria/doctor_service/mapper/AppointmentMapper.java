package com.devteria.doctor_service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import com.devteria.doctor_service.dto.request.AppointmentRequest;
import com.devteria.doctor_service.dto.response.AppointmentResponse;
import com.devteria.doctor_service.entity.Appointment;

@Mapper(componentModel = "spring")
public interface AppointmentMapper {
    Appointment toAppointment(AppointmentRequest request);

    AppointmentResponse toAppointmentResponse(Appointment appointment);

    void updateAppointment(@MappingTarget Appointment appointment, AppointmentRequest request);
}
