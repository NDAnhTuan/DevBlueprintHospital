package com.devteria.swagger.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.devteria.swagger.dto.request.DoctorCreationRequest;
import com.devteria.swagger.dto.response.DoctorCreationResponse;
import com.devteria.swagger.entity.Doctor;
import com.devteria.swagger.exception.DoctorNotFoundException;
import com.devteria.swagger.mapper.DoctorMapper;
import com.devteria.swagger.repository.DoctorRepository;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class DoctorServiceImpl implements DoctorService {
    DoctorRepository doctorRepository;
    DoctorMapper doctorMapper;

    @Override
    public DoctorCreationResponse createDoctor(DoctorCreationRequest request) {
        Doctor doctor = doctorMapper.toDoctor(request);
        doctor = doctorRepository.save(doctor);
        return doctorMapper.toDoctorCreationResponse(doctor);
    }

    @Override
    public DoctorCreationResponse getDoctor(String id) {
        Doctor doctor = findDoctorById(id);
        return doctorMapper.toDoctorCreationResponse(doctor);
    }

    @Override
    public List<DoctorCreationResponse> getAllDoctors() {
        return doctorRepository.findAll().stream()
                .map(doctorMapper::toDoctorCreationResponse)
                .collect(Collectors.toList());
    }

    @Override
    public DoctorCreationResponse updateDoctor(String id, DoctorCreationRequest request) {
        findDoctorById(id); // Verify doctor exists

        Doctor updatedDoctor = doctorMapper.toDoctor(request);
        updatedDoctor.setId(id);

        updatedDoctor = doctorRepository.save(updatedDoctor);
        return doctorMapper.toDoctorCreationResponse(updatedDoctor);
    }

    @Override
    public void deleteDoctor(String id) {
        if (!doctorRepository.existsById(id)) {
            throw new DoctorNotFoundException(id);
        }
        doctorRepository.deleteById(id);
    }

    @Override
    public Boolean checkId(String doctorId) {
        return doctorRepository.existsById(doctorId);
    }

    // Helper method to improve single responsibility and code reuse
    private Doctor findDoctorById(String id) {
        return doctorRepository.findById(id).orElseThrow(() -> new DoctorNotFoundException(id));
    }
}
