package com.devteria.swagger.dto.response;

import java.time.LocalDateTime;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AppointmentResponse {
    String id;
    String patientId;
    String doctorId;
    LocalDateTime appointmentDateTime;
    String reason;
    String status;
}
