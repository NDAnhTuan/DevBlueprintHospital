package com.devteria.scheduling.dto.response;

import com.devteria.scheduling.entity.AppointmentStatus;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AppointmentResponse{
    String patientId;
    String doctorId;
    LocalDateTime appointmentTime;
    AppointmentStatus status;
}