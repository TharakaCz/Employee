package com.employee.repository;

import com.employee.model.EmployeeCategory;
import com.employee.model.Mounthly;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MounthlyRepository extends JpaRepository<Mounthly,Long> {

    Mounthly findByEmployeeCategory(EmployeeCategory employeeCategory);
}
