package com.employee.service.service.impl;

import com.employee.service.dto.APIDto;
import com.employee.service.dto.DepartmentDto;
import com.employee.service.dto.EmployeeDto;
import com.employee.service.entity.Employee;
import com.employee.service.mapper.EmployeeMapper;
import com.employee.service.repository.EmployeeRepository;
import com.employee.service.service.APIClient;
import com.employee.service.service.EmployeeService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@AllArgsConstructor
@Service
public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeRepository employeeRepository;
   // private RestTemplate restTemplate;
    private WebClient webClient;
    private APIClient apiClient;
   // private Logger LOGGER = LoggerFactory.getLogger(EmployeeServiceImpl.class);

    @Override
    public EmployeeDto saveEmployee(EmployeeDto employeeDto) {
        Employee employee = EmployeeMapper.mapToEmployee(employeeDto);
        Employee savedEmployee = employeeRepository.save(employee);
        return EmployeeMapper.mapToEmployeeDto(savedEmployee);
    }

   // @CircuitBreaker(name = "${spring.application.name}", fallbackMethod = "getDefaultDepartment")
    @Retry(name = "${spring.application.name}",fallbackMethod = "getDefaultDepartment")
    @Override
    public APIDto getEmployeeById(Long empId) {

       // LOGGER.info("Inside the getEmployeeById method");
        Employee employee = employeeRepository.findById(empId).get();

/*        ResponseEntity<DepartmentDto> responseEntity =
                restTemplate.getForEntity("http://localhost:1000/department/api/"+employee.getId(), DepartmentDto.class);
        DepartmentDto departmentDto = responseEntity.getBody();*/


       DepartmentDto departmentDto = webClient.get().uri("http://localhost:1000/department/api/"+employee.getId())
                .retrieve().bodyToMono(DepartmentDto.class).block();

        EmployeeDto employeeDto = EmployeeMapper.mapToEmployeeDto(employee);
        //DepartmentDto departmentDto = apiClient.getDeparmentByCode(employee.getId());

        APIDto apiDto = new APIDto();
        apiDto.setEmployee(employeeDto);
        apiDto.setDepartment(departmentDto);
        return apiDto;
    }

    public APIDto getDefaultDepartment(Long empId, Exception e) {
        Employee employee = employeeRepository.findById(empId).get();
        //LOGGER.info("Inside the getDefaultDepartment method");

        DepartmentDto departmentDto = new DepartmentDto();
        departmentDto.setId(101L);
        departmentDto.setDepartmentCode("RD00930");
        departmentDto.setDepartmentDescription("Research and Development");
        departmentDto.setName("R&D Department");


        EmployeeDto employeeDto = EmployeeMapper.mapToEmployeeDto(employee);
       // DepartmentDto departmentDto = apiClient.getDeparmentByCode(employee.getId());

        APIDto apiDto = new APIDto();
        apiDto.setEmployee(employeeDto);
        apiDto.setDepartment(departmentDto);
        return apiDto;
    }

}
