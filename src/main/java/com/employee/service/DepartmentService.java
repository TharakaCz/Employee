package com.employee.service;

import com.employee.helper.DepartmentDTO;
import com.employee.helper.DepartmentResponceDTO;

import java.util.List;

public interface DepartmentService {

    public boolean save(DepartmentDTO departmentDTO)throws Exception;
    public DepartmentResponceDTO edit(Long depId)throws Exception;
    public boolean delete(Long depId)throws Exception;
    public List<DepartmentResponceDTO>getAll()throws Exception;
    public boolean update(DepartmentResponceDTO departmentResponceDTO)throws Exception;
}
