package com.example.employee.web.request;

import com.example.employee.dto.EmployeeDTO;
import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployeeRequest {
    @Valid
    private EmployeeDTO employeeDTO;
}
