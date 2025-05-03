package com.devteria.swagger.validator;

import org.springframework.stereotype.Component;

import com.devteria.swagger.dto.request.DoctorCreationRequest;
import com.devteria.swagger.exception.InvalidDoctorDataException;

@Component
public class DoctorValidator {

    public void validate(DoctorCreationRequest request) {
        if (request == null) {
            throw new InvalidDoctorDataException("Doctor request cannot be null");
        }

        validateEmail(request.getEmail());
        validateName(request.getFirstName(), request.getLastName());
        validateSpecialty(request.getSpecialty());
        validatePhoneNumber(request.getPhoneNumber());
    }

    private void validateEmail(String email) {
        if (email == null || email.isBlank()) {
            throw new InvalidDoctorDataException("Email cannot be empty");
        }

        if (!email.contains("@")) {
            throw new InvalidDoctorDataException("Invalid email format");
        }
    }

    private void validateName(String firstName, String lastName) {
        if (firstName == null || firstName.isBlank()) {
            throw new InvalidDoctorDataException("First name cannot be empty");
        }

        if (lastName == null || lastName.isBlank()) {
            throw new InvalidDoctorDataException("Last name cannot be empty");
        }
    }

    private void validateSpecialty(String specialty) {
        if (specialty == null || specialty.isBlank()) {
            throw new InvalidDoctorDataException("Specialty cannot be empty");
        }
    }

    private void validatePhoneNumber(String phoneNumber) {
        if (phoneNumber == null || phoneNumber.isBlank()) {
            throw new InvalidDoctorDataException("Phone number cannot be empty");
        }

        // Add more validation if needed
    }
}
