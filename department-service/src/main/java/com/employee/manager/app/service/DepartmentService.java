package com.employee.manager.app.service;

import com.employee.manager.app.dto.DepartmentDto;

public interface DepartmentService {

    DepartmentDto saveDepartment(DepartmentDto departmentDto);
    DepartmentDto getDepartmentByCode(Long deptId);
}
