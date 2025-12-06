package com.example.employee.exception;

import lombok.Getter;

@Getter
public enum EmployeeErrorCodeTemplate {

    GENERAL_ERROR(1001, "An unexpected error occurred"),
    UNKNOWN_ERROR(1000, "Unknown exception occured"),
    USER_NOT_FOUND(3001, "User not found"),
    INVALID_INPUT(2002, "Invalid input");

    private final int errorCode;
    private final String message;

    EmployeeErrorCodeTemplate(int errorCode, String message) {
        this.errorCode = errorCode;
        this.message = message;
    }

}
