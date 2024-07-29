package com.employee.manager.app.service.impl;

import com.employee.manager.app.dto.DepartmentDto;
import com.employee.manager.app.entity.Department;
import com.employee.manager.app.mapper.DepartmentMapper;
import com.employee.manager.app.repository.DepartmentRepository;
import com.employee.manager.app.service.DepartmentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

    private DepartmentRepository departmentRepository;
    @Override
    public DepartmentDto saveDepartment(DepartmentDto departmentDto) {
        Department department = DepartmentMapper.mapToDepartment(departmentDto);
        Department saveDepartment = departmentRepository.save(department);
        return DepartmentMapper.mapToDepartmentDto(saveDepartment);
    }

    @Override
    public DepartmentDto getDepartmentByCode(Long departmentId) {
        Department department = departmentRepository.findById(departmentId).get();
        return DepartmentMapper.mapToDepartmentDto(department);
    }
}
