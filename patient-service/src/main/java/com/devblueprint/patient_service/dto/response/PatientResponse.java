package com.devblueprint.patient_service.dto.response;

import java.time.LocalDate;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PatientResponse {
    String id;
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
