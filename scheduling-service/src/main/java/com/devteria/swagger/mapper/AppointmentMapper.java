package com.devteria.swagger.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import com.devteria.swagger.dto.request.AppointmentRequest;
import com.devteria.swagger.dto.response.AppointmentResponse;
import com.devteria.swagger.entity.Appointment;

// Only non-null values will be updated
@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface AppointmentMapper {
    Appointment toAppointment(AppointmentRequest request);

    AppointmentResponse toAppointmentResponse(Appointment appointment);

    void updateAppointment(@MappingTarget Appointment appointment, AppointmentRequest request);
}
