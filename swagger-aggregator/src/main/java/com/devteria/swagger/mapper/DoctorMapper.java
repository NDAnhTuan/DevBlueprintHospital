package com.devteria.swagger.mapper;

import com.devteria.swagger.dto.request.DoctorCreationRequest;
import com.devteria.swagger.dto.response.DoctorCreationResponse;
import com.devteria.swagger.entity.Doctor;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DoctorMapper {

    Doctor toDoctor(DoctorCreationRequest request);

    DoctorCreationResponse toDoctorCreationResponse(Doctor doctor);
}
