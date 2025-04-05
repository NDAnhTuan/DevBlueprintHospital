package com.devteria.doctor_service.mapper;

import com.devteria.doctor_service.dto.request.DoctorCreationRequest;
import com.devteria.doctor_service.dto.response.DoctorCreationResponse;
import com.devteria.doctor_service.entity.Doctor;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DoctorMapper {

    Doctor toDoctor(DoctorCreationRequest request);

    DoctorCreationResponse toDoctorCreationResponse(Doctor doctor);
}
