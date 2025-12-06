package com.example.employee.exception;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class MicroException extends RuntimeException {

    private final EmployeeErrorCodeTemplate errorTemplate;

    public MicroException(EmployeeErrorCodeTemplate errorTemplate) {
        super(errorTemplate.getMessage());
        this.errorTemplate = errorTemplate;
    }

    public MicroException(EmployeeErrorCodeTemplate errorTemplate, String customMessage) {
        super(customMessage);
        this.errorTemplate = errorTemplate;
    }

}
