package com.devteria.swagger.exception;

public class DoctorNotFoundException extends AppException {
    public DoctorNotFoundException(String id) {
        super(ErrorCode.DOCTOR_NOT_EXISTED);
    }

    public DoctorNotFoundException() {
        super(ErrorCode.DOCTOR_NOT_EXISTED);
    }
}
