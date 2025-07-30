package com.example.employee.exception;

public class ExceptionHandler {

    // Custom exception for employee not found
    public static class EmployeeNotFoundException extends RuntimeException {
        public EmployeeNotFoundException(Long id) {
            super("Employee not found with id: " + id);
        }
    }

    // Custom exception for invalid employee data
    public static class InvalidEmployeeDataException extends RuntimeException {
        public InvalidEmployeeDataException(String message) {
            super("Invalid employee data: " + message);
        }
    }

    // Custom exception for duplicate email
    public static class DuplicateEmailException extends RuntimeException {
        public DuplicateEmailException(String email) {
            super("An employee with email " + email + " already exists.");
        }
    }
}
