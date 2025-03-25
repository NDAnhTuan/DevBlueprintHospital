package com.devteria.scheduling.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Table(name = "appointments")
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @ManyToOne
    @JoinColumn(name = "doctor_id", nullable = false)
    Doctor doctor;


    String patientId;

    @Column(nullable = false)
    LocalDateTime appointmentTime;

    @Enumerated(EnumType.STRING)
    AppointmentStatus status; // Đặt - Hủy - Sửa
}
