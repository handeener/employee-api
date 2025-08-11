package com.example.employee.exception;

import com.example.employee.web.response.CustomResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice(basePackages = "com.example.employee.controller")
public class GlobalExceptionHandler {

    private final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(MicroException.class)
    public ResponseEntity<CustomResponse<Void>> handleCustomException(MicroException ex) {
        logger.error("CustomException caught: code={}, message={}", ex.getErrorCode(), ex.getMessage());

        CustomResponse<Void> response = CustomResponse.error(ex.getMessage(), ex.getErrorCode());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<CustomResponse<Void>> handleIllegalArgumentException(IllegalArgumentException ex) {
        logger.error("IllegalArgumentException caught:", ex);
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(CustomResponse.error(ex.getMessage(), 400));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<CustomResponse<Void>> handleOtherExceptions(Exception ex) {
        logger.error("Unhandled exception:", ex);

        CustomResponse<Void> response = CustomResponse.error("Unexpected error occured", HttpStatus.INTERNAL_SERVER_ERROR.value());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
    }
}

