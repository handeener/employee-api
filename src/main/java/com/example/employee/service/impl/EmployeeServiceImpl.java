package com.example.employee.service.impl;

import com.example.employee.dto.EmployeeDTO;
import com.example.employee.mapper.EmployeeMapper;
import com.example.employee.repository.EmployeeRepository;
import com.example.employee.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository repository;
    @Override
    public EmployeeDTO createEmployee(EmployeeDTO employeeDTO){
        return EmployeeMapper.INSTANCE.toDto(repository.save(EmployeeMapper.INSTANCE.toEntity(employeeDTO)));
    }

    @Override
    public EmployeeDTO updateEmployee(Long id, EmployeeDTO employeeDTO) {
        if (repository.existsById(id)) {
            employeeDTO.setId(id);
            return EmployeeMapper.INSTANCE.toDto(repository.save(EmployeeMapper.INSTANCE.toEntity(employeeDTO)));
        }
        return null;
    }

    @Override
    public void deleteEmployee(Long id) {
        repository.deleteById(id);
    }

    @Override
    public EmployeeDTO getEmployeeById(Long id) {
        return EmployeeMapper.INSTANCE.toDto(
                repository.findById(id).orElseThrow(() -> new RuntimeException("Employee not found")));
    }

    @Override
    public List<EmployeeDTO> getAllEmployees() {
        return repository.findAll().stream().map(EmployeeMapper.INSTANCE::toDto)
                .collect(Collectors.toList());
    }
}
