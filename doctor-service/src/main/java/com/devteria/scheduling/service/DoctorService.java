package com.devteria.scheduling.service;

import com.devteria.scheduling.dto.request.DoctorCreationRequest;
import com.devteria.scheduling.dto.response.DoctorCreationResponse;
import com.devteria.scheduling.entity.Doctor;
import com.devteria.scheduling.exception.AppException;
import com.devteria.scheduling.exception.ErrorCode;
import com.devteria.scheduling.mapper.DoctorMapper;
import com.devteria.scheduling.repository.DoctorRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class DoctorService {
    DoctorRepository doctorRepository;
    DoctorMapper doctorMapper;

    public DoctorCreationResponse createDoctor(DoctorCreationRequest request) {
        Doctor doctor = doctorMapper.toDoctor(request);
        doctor = doctorRepository.save(doctor);
        return doctorMapper.toDoctorCreationResponse(doctor);
    }

    public DoctorCreationResponse getDoctor(String id) {
        Doctor doctor = doctorRepository.findById(id)
                .orElseThrow(() -> new AppException(ErrorCode.DOCTOR_NOT_EXISTED));
        return doctorMapper.toDoctorCreationResponse(doctor);
    }

    public List<DoctorCreationResponse> getAllDoctors() {
        return doctorRepository.findAll().stream()
                .map(doctorMapper::toDoctorCreationResponse)
                .collect(Collectors.toList());
    }

    public DoctorCreationResponse updateDoctor(String id, DoctorCreationRequest request) {
        Doctor existingDoctor = doctorRepository.findById(id)
                .orElseThrow(() -> new AppException(ErrorCode.DOCTOR_NOT_EXISTED));
        
        Doctor updatedDoctor = doctorMapper.toDoctor(request);
        updatedDoctor.setId(id);
        
        updatedDoctor = doctorRepository.save(updatedDoctor);
        return doctorMapper.toDoctorCreationResponse(updatedDoctor);
    }

    public void deleteDoctor(String id) {
        if (!doctorRepository.existsById(id)) {
            throw new AppException(ErrorCode.DOCTOR_NOT_EXISTED);
        }
        doctorRepository.deleteById(id);
    }
} 