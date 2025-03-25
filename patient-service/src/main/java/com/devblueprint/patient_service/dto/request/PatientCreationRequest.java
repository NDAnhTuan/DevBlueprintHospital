package com.devblueprint.patient_service.dto.request;

import java.time.LocalDate;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PatientCreationRequest {
    String firstName;
    String lastName;
    String gender;
    String ethnicity;
    String patientType;
    String relativeName;
    LocalDate dob;
    String address;
    String insuranceNumber;
    String insuranceType;
    String hospitalLevel;
}
