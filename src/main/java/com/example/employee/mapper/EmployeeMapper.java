package com.example.employee.mapper;
import com.example.employee.dto.EmployeeDTO;
import com.example.employee.entity.Employee;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {

    EmployeeDTO toDto(Employee employee);
    Employee toEntity(EmployeeDTO employeeDTO);
    List<EmployeeDTO> toDtoList(List<Employee> employees);
    List<Employee> toEntityList(List<EmployeeDTO> employeeDTOs);
}
