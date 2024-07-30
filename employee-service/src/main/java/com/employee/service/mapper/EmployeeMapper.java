package com.employee.service.mapper;

import com.employee.service.dto.EmployeeDto;
import com.employee.service.entity.Employee;

public class EmployeeMapper {

    public static Employee mapToEmployee(EmployeeDto employeeDto){
        Employee employee = new Employee(
                employeeDto.getEmpId(),
                employeeDto.getFirstName(),
                employeeDto.getLastName(),
                employeeDto.getEmail(),
                employeeDto.getId(),
                employeeDto.getOrgCode()
        );
        return employee;
    }

    public static EmployeeDto mapToEmployeeDto(Employee employee){
        EmployeeDto employeeDto = new EmployeeDto(
                employee.getEmpId(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getEmail(),
                employee.getId(),
                employee.getOrgCode()
        );
        return employeeDto;
    }
}
