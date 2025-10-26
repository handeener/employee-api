package com.example.employee.service;

import com.example.employee.dto.EmployeeDTO;
import com.example.employee.exception.MicroException;
import com.example.employee.mapper.EmployeeMapper;
import com.example.employee.repository.EmployeeRepository;
import com.example.employee.web.request.EmployeeRequest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class EmployeeServiceTest {

    @InjectMocks
    EmployeeServiceImpl service;
    @Mock
    EmployeeRepository repository;

    @Test
    void givenValidInput_whenCreateEmployee_thenReturnEmployee() {
        EmployeeRequest request = new EmployeeRequest();
        request.setEmployeeDTO(new EmployeeDTO());

        when(repository.save(any())).thenReturn(EmployeeMapper.INSTANCE.toEntity(request.getEmployeeDTO()));
        EmployeeDTO createdEmployee = service.createEmployee(request);

        assertNotNull(createdEmployee);
        assertEquals(request.getEmployeeDTO().getFirstName(), createdEmployee.getFirstName());
    }

    @Test
    void givenValidId_whenUpdateEmployee_thenReturnUpdatedEmployee() {
        Long id = 1L;
        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setId(id);

        when(repository.existsById(id)).thenReturn(Boolean.TRUE);
        when(repository.save(any())).thenReturn(EmployeeMapper.INSTANCE.toEntity(employeeDTO));
        EmployeeDTO updatedEmployee = service.updateEmployee(id, employeeDTO);

        assertEquals(updatedEmployee.getId(), employeeDTO.getId());
    }

    @Test
    void givenId_whenUpdateEmployee_thenReturnException() {
        Long id = 1L;
        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setId(id);

        when(repository.existsById(id)).thenReturn(Boolean.FALSE);
        MicroException exception = assertThrows(MicroException.class, () -> service.updateEmployee(id, employeeDTO));

        assertEquals("User not found", exception.getMessage());
    }

    @Test
    void givenValidId_whenDeleteEmployee_thenReturnNoException() {
        Long id = 1L;

        when(repository.existsById(id)).thenReturn(Boolean.TRUE);

        assertDoesNotThrow(() -> service.deleteEmployee(id));
    }

    @Test
    void givenInValidId_whenDeleteEmployee_thenReturnException() {
        Long id = 1L;

        when(repository.existsById(id)).thenReturn(Boolean.FALSE);
        MicroException exception = assertThrows(MicroException.class, () -> service.deleteEmployee(id));

        assertEquals("User not found", exception.getMessage());
    }

    @Test
    void givenValidId_whenGetEmployeeById_thenReturnEmployee() {
        Long id = 1L;
        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setId(id);

        when(repository.findById(id)).thenReturn(java.util.Optional.of(EmployeeMapper.INSTANCE.toEntity(employeeDTO)));
        EmployeeDTO foundEmployee = service.getEmployeeById(id);

        assertNotNull(foundEmployee);
    }

    @Test
    void givenId_whenGetEmployeeById_thenReturnException() {
        Long id = 1L;

        when(repository.findById(id)).thenReturn(Optional.empty());
        MicroException exception = assertThrows(MicroException.class, () -> service.getEmployeeById(id));

        assertEquals("User not found", exception.getMessage());
    }

    @Test
    void whenGetAllEmployees_thenReturnListOfEmployees() {
        EmployeeDTO employeeDTO = new EmployeeDTO();

        when(repository.findAll())
                .thenReturn(java.util.Collections.singletonList(EmployeeMapper.INSTANCE.toEntity(employeeDTO)));
        List<EmployeeDTO> employees = service.getAllEmployees();

        assertNotNull(employees);
        assertFalse(employees.isEmpty());
        assertEquals(1, employees.size());
        assertEquals(employeeDTO.getFirstName(), employees.getFirst().getFirstName());
    }


}
