package com.devteria.swagger.dto.request;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class DoctorCreationRequest {
    String firstName;
    String lastName;
    String specialty;
    String phoneNumber;
    String email;
}
