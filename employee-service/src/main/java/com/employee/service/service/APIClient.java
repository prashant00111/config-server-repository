package com.employee.service.service;

import com.employee.service.dto.DepartmentDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//@FeignClient(url = "http://localhost:1000", value = "department-service")
@FeignClient(name ="DEPARTMENT-SERVICE")
public interface APIClient {
    @GetMapping("department/api/{id}")
    DepartmentDto getDeparmentByCode(@PathVariable("id") Long departmentId);

}
