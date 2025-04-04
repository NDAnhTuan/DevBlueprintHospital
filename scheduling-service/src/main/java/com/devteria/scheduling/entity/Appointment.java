package com.devteria.scheduling.entity;

import java.time.LocalDateTime;

import jakarta.persistence.*;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "appointment")
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    String id;

    @Column(name = "doctor_id", nullable = false)
    String doctorId;

    @Column(name = "patient_id", nullable = false)
    String patientId;

    @Column(name = "reason")
    String reason;

    @Column(name = "status")
    String status;

    @Column(name = "appointment_date_time", nullable = false)
    LocalDateTime appointmentDateTime;
}
