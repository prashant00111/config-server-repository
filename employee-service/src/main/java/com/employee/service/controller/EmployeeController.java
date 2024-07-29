package com.employee.service.controller;

import com.employee.service.dto.APIDto;
import com.employee.service.dto.EmployeeDto;
import com.employee.service.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("api/employee")
public class EmployeeController {

    private EmployeeService employeeService;

    @PostMapping
    public ResponseEntity<EmployeeDto> saveEmployee(@RequestBody EmployeeDto employeeDto){
        EmployeeDto savedEmployee = employeeService.saveEmployee(employeeDto);

        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<APIDto> getEmployeeById(@PathVariable("id") Long empId){
        APIDto employeeDto = employeeService.getEmployeeById(empId);
        return new ResponseEntity<>(employeeDto,HttpStatus.OK);
    }
}
