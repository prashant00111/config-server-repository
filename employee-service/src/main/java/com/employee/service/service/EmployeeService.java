package com.employee.service.service;

import com.employee.service.dto.APIDto;
import com.employee.service.dto.EmployeeDto;

public interface EmployeeService {

    EmployeeDto saveEmployee(EmployeeDto employeeDto);
    APIDto getEmployeeById(Long id);
}
