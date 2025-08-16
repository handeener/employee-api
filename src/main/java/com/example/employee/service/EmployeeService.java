package com.example.employee.service;

import com.example.employee.dto.EmployeeDTO;
import com.example.employee.web.request.EmployeeRequest;

import java.util.List;

public interface EmployeeService {
    EmployeeDTO createEmployee(EmployeeRequest request);
    EmployeeDTO updateEmployee(Long id, EmployeeDTO employeeDTO);
    void deleteEmployee(Long id);
    EmployeeDTO getEmployeeById(Long id);
    List<EmployeeDTO> getAllEmployees();

}
