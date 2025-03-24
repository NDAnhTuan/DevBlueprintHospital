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
@Table(name = "patient", uniqueConstraints = {@UniqueConstraint(columnNames = "insuaranceNumber")})

public class Patient
{
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    String id;

    @Column(nullable = false, unique = true)
    String userId;
    String firstName;
    String lastName;
    String gender;
    String ethnicity;
    String patientType;
    String relativeName;
    LocalDate dob;
    String address;
    String hospitalLevel;

    @Column(nullable = false,unique = true) //Đảm bảo insuranceNumber unique để tìm Bệnh nhân
    String insuranceNumber;
    String insuranceType;
}
