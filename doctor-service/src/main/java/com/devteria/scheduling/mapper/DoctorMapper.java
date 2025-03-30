package com.devteria.scheduling.mapper;

import com.devteria.scheduling.dto.request.DoctorCreationRequest;
import com.devteria.scheduling.dto.response.DoctorCreationResponse;
import com.devteria.scheduling.entity.Doctor;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DoctorMapper {

    Doctor toDoctor(DoctorCreationRequest request);

    DoctorCreationResponse toDoctorCreationResponse(Doctor doctor);
}
