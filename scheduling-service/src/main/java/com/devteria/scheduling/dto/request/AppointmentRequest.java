package com.devteria.scheduling.dto.request;

import java.time.LocalDateTime;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AppointmentRequest {
    String patientId;
    String doctorId;
    LocalDateTime appointmentDateTime;
    String reason;
    String status;
}
