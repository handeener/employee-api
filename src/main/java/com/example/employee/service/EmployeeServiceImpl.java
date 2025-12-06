package com.example.employee.service;

import com.example.employee.dto.EmployeeDTO;
import com.example.employee.entity.Employee;
import com.example.employee.exception.EmployeeErrorCodeTemplate;
import com.example.employee.exception.MicroException;
import com.example.employee.mapper.EmployeeMapper;
import com.example.employee.repository.EmployeeRepository;
import com.example.employee.web.request.EmployeeRequest;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository repository;
    private final EmployeeMapper mapper;

    @Override
    public void createEmployee(EmployeeRequest request) throws MicroException {
        System.out.println(">>>REQUEST BODY: " + request);

        Employee entity = mapper.toEntity(request.getEmployeeDTO());
        System.out.println(">>> ENTITY = " + entity);
        repository.save(entity);
    }

    @Override
    public EmployeeDTO updateEmployee(Long id, EmployeeDTO employeeDTO) {
        Employee existingEmployee = repository.findById(id)
                .orElseThrow(() -> new MicroException(EmployeeErrorCodeTemplate.USER_NOT_FOUND));

        existingEmployee.setFirstName(employeeDTO.getFirstName());
        existingEmployee.setDepartment(employeeDTO.getDepartment());
        existingEmployee.setEmail(employeeDTO.getEmail());
        existingEmployee.setPosition(employeeDTO.getPosition());
        Employee updatedEmployee = repository.save(existingEmployee);
        return mapper.toDto(updatedEmployee);
    }

    @Override
    public void deleteEmployee(Long id) {
        if (!repository.existsById(id)) {
            throw new MicroException(EmployeeErrorCodeTemplate.USER_NOT_FOUND);
        }
        repository.deleteById(id);
    }

    @Override
    public EmployeeDTO getEmployeeById(Long id) {
        Employee employee = repository.findById(id)
                .orElseThrow(() -> new MicroException(EmployeeErrorCodeTemplate.USER_NOT_FOUND));
        return mapper.toDto(employee);
    }

    @Override
    public List<EmployeeDTO> getAllEmployees() {
        return repository.findAll().stream().map(mapper::toDto)
                .collect(Collectors.toList());
    }

    @PostConstruct
    public void testMapper() {
        System.out.println(">>> MAPPER CLASS: " + mapper.getClass().getName());
    }
}
