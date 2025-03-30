package com.devteria.scheduling.repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.devteria.scheduling.entity.Appointment;

import feign.Param;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, String> {
    // Find an appointment by doctorId or patientId
    List<Appointment> findAllByDoctorId(String doctorId);

    List<Appointment> findAllByPatientId(String patientId);

    // Find an appointment by id
    Optional<Appointment> findById(String id);

    // Check if the doctor has an appointment within 1 hour of the requested time
    @Query("SELECT COUNT(a) > 0 FROM Appointment a " + "WHERE a.doctorId = :doctorId "
            + "AND ABS(TIMESTAMPDIFF(MINUTE, a.appointmentDateTime, :appointmentDateTime)) < 60")
    boolean existsByDoctorIdAndTimeConflict(
            @Param("doctorId") String doctorId, @Param("appointmentDateTime") LocalDateTime appointmentDateTime);
}
