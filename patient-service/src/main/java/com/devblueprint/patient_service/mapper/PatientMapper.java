package com.devblueprint.patient_service.mapper;

import com.devblueprint.patient_service.dto.request.PatientCreationRequest;
import com.devblueprint.patient_service.dto.request.PatientUpdateRequest;
import com.devblueprint.patient_service.dto.response.PatientResponse;
import com.devblueprint.patient_service.entity.Patient;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface PatientMapper {
    Patient toPatient(PatientCreationRequest request);

    PatientResponse toPatientResponse(Patient entity);

    void updatePatient(@MappingTarget Patient patient, PatientUpdateRequest request);
}
