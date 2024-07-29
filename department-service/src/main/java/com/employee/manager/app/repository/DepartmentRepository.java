package com.employee.manager.app.repository;

import com.employee.manager.app.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface DepartmentRepository extends JpaRepository<Department,Long> {
 /*   @Query("SELECT * from Departments where dept_code = deptCode")
    Department findByDepartmentCode(String departmentCode);*/
}
