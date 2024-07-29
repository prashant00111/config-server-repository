package com.employee.manager.app.mapper;

import com.employee.manager.app.dto.DepartmentDto;
import com.employee.manager.app.entity.Department;

public class DepartmentMapper {

    public static Department mapToDepartment(DepartmentDto departmentDto){
        Department department = new Department(
                departmentDto.getId(),
                departmentDto.getName(),
                departmentDto.getDepartmentDescription(),
                departmentDto.getDepartmentCode()
        );
        return department;
    }
    public static DepartmentDto mapToDepartmentDto(Department department){
        DepartmentDto departmentDto = new DepartmentDto(
                department.getId(),
                department.getName(),
                department.getDepartmentDescription(),
                department.getDepartmentCode()
        );
        return departmentDto;
    }
}
