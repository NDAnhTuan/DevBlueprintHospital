package com.devteria.swagger.service;

import java.util.List;

import com.devteria.swagger.dto.request.DoctorCreationRequest;
import com.devteria.swagger.dto.response.DoctorCreationResponse;

public interface DoctorService {

    DoctorCreationResponse createDoctor(DoctorCreationRequest request);

    DoctorCreationResponse getDoctor(String id);

    List<DoctorCreationResponse> getAllDoctors();

    DoctorCreationResponse updateDoctor(String id, DoctorCreationRequest request);

    void deleteDoctor(String id);

    Boolean checkId(String doctorId);
}
