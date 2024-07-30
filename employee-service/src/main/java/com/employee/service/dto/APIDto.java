package com.employee.service.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class APIDto {
    private EmployeeDto employee;
    private DepartmentDto department;
    private OrganizationDto organizationDto;
}
