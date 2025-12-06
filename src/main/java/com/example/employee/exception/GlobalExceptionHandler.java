package com.example.employee.exception;

import com.example.employee.web.response.ApiError;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;
import java.util.Optional;

@ControllerAdvice(basePackages = "com.example.employee.controller")
public class GlobalExceptionHandler {

    private final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(MicroException.class)
    public ResponseEntity<ApiError> handleMicroException(MicroException ex) {
        logger.error("Exception caught: code={}, message={}", ex.getErrorTemplate().getErrorCode(), ex.getMessage());
        ApiError error = ApiError.builder()
                .code(ex.getErrorTemplate().name())
                .message(ex.getErrorTemplate().getMessage())
                .status(ex.getErrorTemplate().getErrorCode())
                .timestamp(Instant.now())
                .build();
        return ResponseEntity.status(ex.getErrorTemplate().getErrorCode()).body(error);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ApiError> handleIllegalArgumentException(IllegalArgumentException ex) {
        logger.error("IllegalArgumentException caught:", ex);
        String message = Optional.ofNullable(ex.getMessage()).orElse("Invalid Argument");
        ApiError response = ApiError.builder()
                .code("INVALID_ARGUMENT")
                .message(message)
                .status(HttpStatus.BAD_REQUEST.value())
                .timestamp(Instant.now())
                .build();
        return ResponseEntity.badRequest().body(response);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiError> handleValidationException(MethodArgumentNotValidException ex){
        String message = ex.getBindingResult().getFieldErrors().stream()
                .findFirst()
                .map(error -> error.getField() + ": "  + error.getDefaultMessage())
                .orElse("Invalid request");

        ApiError response = ApiError.builder()
                .code("VALIDATION_ERROR")
                .message(message)
                .status(HttpStatus.BAD_REQUEST.value())
                .timestamp(Instant.now())
                .build();
        return ResponseEntity.badRequest().body(response);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiError> handleGeneralException(Exception ex){
        ApiError response = ApiError.builder()
                .code("INTERNAL_ERROR")
                .message("Unexpected Error Occured: " + ex.getMessage())
                .status(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .timestamp(Instant.now())
                .build();
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
    }
}

