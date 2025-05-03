package com.devteria.swagger.exception;

public class InvalidDoctorDataException extends AppException {
    public InvalidDoctorDataException(String message) {
        super(ErrorCode.INVALID_KEY);
    }

    public InvalidDoctorDataException() {
        super(ErrorCode.INVALID_KEY);
    }
}
