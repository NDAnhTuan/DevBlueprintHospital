package com.devteria.scheduling.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import com.devteria.scheduling.dto.request.AppointmentRequest;
import com.devteria.scheduling.dto.response.AppointmentResponse;
import com.devteria.scheduling.entity.Appointment;

@Mapper(componentModel = "spring")
public interface AppointmentMapper {
    Appointment toAppointment(AppointmentRequest request);

    AppointmentResponse toAppointmentResponse(Appointment appointment);

    void updateAppointment(@MappingTarget Appointment appointment, AppointmentRequest request);
}
