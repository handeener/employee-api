package com.example.employee.web.response;

import lombok.Builder;
import lombok.Data;

import java.time.Instant;

@Data
@Builder
public class ApiError{

    private String code;
    private String message;
    private int status;
    private Instant timestamp;
}
