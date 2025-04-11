package com.devteria.swagger.dto.request;

import jakarta.validation.constraints.NotNull;

public class DoctorCreationRequest {
    @NotNull
    String userId; // ID từ hệ thống xác thực

    String firstName;
    String lastName;
    String specialty;
    String phoneNumber;
    String email;
}
