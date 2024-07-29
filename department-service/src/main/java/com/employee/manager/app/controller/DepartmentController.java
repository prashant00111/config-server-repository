package com.employee.manager.app.controller;

import com.employee.manager.app.dto.DepartmentDto;
import com.employee.manager.app.service.DepartmentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("department/api")
@AllArgsConstructor
public class DepartmentController {

    private DepartmentService departmentService;

    @PostMapping
    public ResponseEntity<DepartmentDto> saveDepartment(@RequestBody DepartmentDto departmentDto){
        DepartmentDto dto = departmentService.saveDepartment(departmentDto);
        return new ResponseEntity<>(dto, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<DepartmentDto> getDeparmentByCode(@PathVariable("id") Long departmentId){
        DepartmentDto departmentDto = departmentService.getDepartmentByCode(departmentId);
        return new ResponseEntity<>(departmentDto,HttpStatus.OK);
    }
}
