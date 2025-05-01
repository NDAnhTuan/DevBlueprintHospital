package com.devteria.swagger.mapper;

import org.mapstruct.Mapper;

import com.devteria.swagger.dto.request.DoctorCreationRequest;
import com.devteria.swagger.dto.response.DoctorCreationResponse;
import com.devteria.swagger.entity.Doctor;

@Mapper(componentModel = "spring")
public interface DoctorMapper {

    Doctor toDoctor(DoctorCreationRequest request);

    DoctorCreationResponse toDoctorCreationResponse(Doctor doctor);
}
