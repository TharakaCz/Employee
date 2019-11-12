package com.employee.service;

import com.employee.helper.EmployeeCategoryDTO;
import com.employee.helper.EmployeeResponceDTO;


import java.util.List;

public interface EmployeeCategoryService {

    public boolean save(EmployeeCategoryDTO employeeCategoryDTO)throws Exception;
    public EmployeeResponceDTO edit(Long empId)throws Exception;
    public boolean delete(Long empid)throws Exception;
    public List<EmployeeResponceDTO>getAll()throws Exception;
    public boolean update(EmployeeResponceDTO employeeResponceDTO)throws Exception;

}
