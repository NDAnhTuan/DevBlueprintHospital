package com.devteria.doctor_service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import com.devteria.doctor_service.dto.request.AppointmentRequest;
import com.devteria.doctor_service.dto.response.AppointmentResponse;
import com.devteria.doctor_service.entity.Appointment;

// Only non-null values will be updated
@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface AppointmentMapper {
    Appointment toAppointment(AppointmentRequest request);

    AppointmentResponse toAppointmentResponse(Appointment appointment);

    void updateAppointment(@MappingTarget Appointment appointment, AppointmentRequest request);
}
