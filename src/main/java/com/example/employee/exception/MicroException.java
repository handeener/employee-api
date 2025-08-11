package com.example.employee.exception;

import lombok.Getter;

@Getter
public class MicroException extends RuntimeException {

    private final int errorCode;
    private final String message;

    public MicroException(EmployeeException errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode.getErrorCode();
        this.message = errorCode.getMessage();
    }

    public MicroException(String message, int errorCode) {
        super(message);
        this.errorCode = errorCode;
        this.message = message;
    }

    public MicroException(String message, Throwable cause, int errorCode) {
        super(message, cause);
        this.errorCode = errorCode;
        this.message = message;
    }

    public MicroException(Throwable cause, int errorCode, String message) {
        super(cause);
        this.errorCode = errorCode;
        this.message = message;
    }

}
