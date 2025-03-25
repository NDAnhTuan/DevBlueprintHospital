package com.devteria.scheduling.mapper;

import com.devteria.scheduling.dto.request.AppointmentRequest;

import com.devteria.scheduling.dto.response.AppointmentResponse;
import com.devteria.scheduling.entity.Appointment;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper(componentModel = "spring")
public interface AppointmentMapper {
    @Mapping(target = "doctor.id", source = "doctorId")
    Appointment toAppointment(AppointmentRequest request);
    @Mapping(target = "doctorId", source = "doctor.id")
    AppointmentResponse toAppointmentResponse(Appointment entity);
}