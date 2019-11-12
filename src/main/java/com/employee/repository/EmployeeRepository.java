package com.employee.repository;

import com.employee.model.Department;
import com.employee.model.EmployeeCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<EmployeeCategory,Long> {

    EmployeeCategory findByDepartment(Department department);
}
