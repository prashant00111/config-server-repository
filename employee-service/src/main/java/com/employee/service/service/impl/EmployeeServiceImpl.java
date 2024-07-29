package com.employee.service.service.impl;

import com.employee.service.dto.APIDto;
import com.employee.service.dto.DepartmentDto;
import com.employee.service.dto.EmployeeDto;
import com.employee.service.entity.Employee;
import com.employee.service.mapper.EmployeeMapper;
import com.employee.service.repository.EmployeeRepository;
import com.employee.service.service.APIClient;
import com.employee.service.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@AllArgsConstructor
@Service
public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeRepository employeeRepository;
   // private RestTemplate restTemplate;
    //private WebClient webClient;
    private APIClient apiClient;

    @Override
    public EmployeeDto saveEmployee(EmployeeDto employeeDto) {
        Employee employee = EmployeeMapper.mapToEmployee(employeeDto);
        Employee savedEmployee = employeeRepository.save(employee);
        return EmployeeMapper.mapToEmployeeDto(savedEmployee);
    }

    @Override
    public APIDto getEmployeeById(Long empId) {
        Employee employee = employeeRepository.findById(empId).get();

/*        ResponseEntity<DepartmentDto> responseEntity =
                restTemplate.getForEntity("http://localhost:1000/department/api/"+employee.getId(), DepartmentDto.class);
        DepartmentDto departmentDto = responseEntity.getBody();*/


/*        DepartmentDto departmentDto = webClient.get().uri("http://localhost:1000/department/api/"+employee.getId())
                .retrieve().bodyToMono(DepartmentDto.class).block();*/

        EmployeeDto employeeDto = EmployeeMapper.mapToEmployeeDto(employee);
        DepartmentDto departmentDto = apiClient.getDeparmentByCode(employee.getId());

        APIDto apiDto = new APIDto();
        apiDto.setEmployee(employeeDto);
        apiDto.setDepartment(departmentDto);
        return apiDto;
    }
}
