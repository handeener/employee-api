package com.example.employee.dto;

import lombok.*;

@Getter
@Setter
public class EmployeeDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String department;
    private String position;
    private String phoneNumber;
    private String address;
}
