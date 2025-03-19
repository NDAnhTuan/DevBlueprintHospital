package com.devblueprint.patient_service.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity

public class Patient
{
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    String id;
    String userId;
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
