package com.employee.service.impl;

import com.employee.helper.DepartmentDTO;
import com.employee.helper.DepartmentResponceDTO;
import com.employee.model.Department;
import com.employee.model.EmployeeCategory;
import com.employee.repository.DepartmentRepository;
import com.employee.repository.EmployeeRepository;
import com.employee.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;
    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public boolean save(DepartmentDTO departmentDTO) throws Exception {

        Department department = new Department();

        department.setDiscription(departmentDTO.getDiscription());

        if (departmentRepository.save(department) !=null){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public DepartmentResponceDTO edit(Long depId) throws Exception {

       DepartmentResponceDTO departmentResponceDTO = departmentEdit(depId);

        return departmentResponceDTO;
    }

    @Override
    public boolean delete(Long depId) throws Exception {

        Department department = departmentRepository.deleteByDepId(depId);

        if (department != null){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public List<DepartmentResponceDTO> getAll() throws Exception {
        List<Department>departmentList = departmentRepository.findAll();
        ArrayList<DepartmentResponceDTO>departmentResponceDTOS = new ArrayList<>();

        departmentList.forEach(each->{
            try {
                departmentResponceDTOS.add(getAllDepartment(each));
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        return departmentResponceDTOS;
    }

    @Override
    public boolean update(DepartmentResponceDTO departmentResponceDTO) throws Exception {
        Department department = departmentRepository.findById(departmentResponceDTO.getDepId()).get();

        department.setDiscription(departmentResponceDTO.getDiscription());

        if (departmentRepository.save(department) !=null){
            return true;
        }else {
            return false;
        }
    }


    private DepartmentResponceDTO departmentEdit(Long depId)throws Exception{

        DepartmentResponceDTO departmentResponceDTO = new DepartmentResponceDTO();
        Department department = departmentRepository.findById(depId).get();

        departmentResponceDTO.setDepId(department.getDepId());
        departmentResponceDTO.setDiscription(department.getDiscription());

        return departmentResponceDTO;
    }

    private DepartmentResponceDTO getAllDepartment(Department department)throws Exception{

        DepartmentResponceDTO departmentResponceDTO = new DepartmentResponceDTO();
        departmentResponceDTO.setDepId(department.getDepId());
        departmentResponceDTO.setDiscription(department.getDiscription());

        return departmentResponceDTO;
    }
}
