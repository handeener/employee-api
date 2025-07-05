package com.example.employee.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmployeeDTO {

    private Long id;
    @NotBlank(message = "First name cannot be blank")
    private String firstName;
    private String lastName;
    @Email(message = "Email should be valid")
    @NotBlank(message = "Email cannot be blank")
    private String email;
    private String department;
    private String position;
    private String phoneNumber;
    private String address;

}
