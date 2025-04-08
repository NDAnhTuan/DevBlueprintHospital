package com.devteria.swagger.dto.response;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class DoctorCreationResponse {
    String id;
    String userId;
    String firstName;
    String lastName;
    String specialty;
    String phoneNumber;
    String email;
}
