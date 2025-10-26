package com.example.employee.service;

import com.example.employee.dto.EmployeeDTO;
import com.example.employee.exception.EmployeeErrorCode;
import com.example.employee.exception.MicroException;
import com.example.employee.mapper.EmployeeMapper;
import com.example.employee.repository.EmployeeRepository;
import com.example.employee.web.request.EmployeeRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    EmployeeRepository repository;

    @Override
    public EmployeeDTO createEmployee(EmployeeRequest request) throws MicroException {
        return EmployeeMapper.INSTANCE.toDto(repository.save(EmployeeMapper.INSTANCE.toEntity(request.getEmployeeDTO())));
    }

    @Override
    public EmployeeDTO updateEmployee(Long id, EmployeeDTO employeeDTO) {
        if (!repository.existsById(id)) {
            throw new MicroException(EmployeeErrorCode.USER_NOT_FOUND);
        }
        employeeDTO.setId(id);
        repository.save(EmployeeMapper.INSTANCE.toEntity(employeeDTO));
        return employeeDTO;
    }

    @Override
    public void deleteEmployee(Long id) {
        if (!repository.existsById(id)) {
            throw new MicroException(EmployeeErrorCode.USER_NOT_FOUND);
        }
        repository.deleteById(id);
    }

    @Override
    public EmployeeDTO getEmployeeById(Long id) {
        return EmployeeMapper.INSTANCE.toDto(
                repository.findById(id).orElseThrow(() -> new MicroException(EmployeeErrorCode.USER_NOT_FOUND)));
    }

    @Override
    public List<EmployeeDTO> getAllEmployees() {
        return repository.findAll().stream().map(EmployeeMapper.INSTANCE::toDto)
                .collect(Collectors.toList());
    }
}
