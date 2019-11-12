package com.employee.service.impl;

import com.employee.helper.DepartmentResponceDTO;
import com.employee.helper.EmployeeCategoryDTO;
import com.employee.helper.EmployeeResponceDTO;
import com.employee.model.Department;
import com.employee.model.EmployeeCategory;
import com.employee.repository.DepartmentRepository;
import com.employee.repository.EmployeeRepository;
import com.employee.service.EmployeeCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeCategoryServiceImpl implements EmployeeCategoryService {

    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public boolean save(EmployeeCategoryDTO employeeCategoryDTO) throws Exception {

        EmployeeCategory employeeCategory = new EmployeeCategory();

        employeeCategory.setName(employeeCategoryDTO.getName());
        employeeCategory.setSalary(employeeCategoryDTO.getSalary());
        Department department = departmentRepository.findById(employeeCategoryDTO.getDepartmentId()).get();
        employeeCategory.setDepartment(department);

        if (employeeRepository.save(employeeCategory) !=null){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public EmployeeResponceDTO edit(Long empId) throws Exception {

        EmployeeResponceDTO employeeResponceDTO = employeeGet(empId);

        return employeeResponceDTO;
    }

    @Override
    public boolean delete(Long empid) throws Exception {

        Optional<EmployeeCategory>optional = employeeRepository.findById(empid);

        if (optional.isPresent()){
            employeeRepository.deleteById(empid);
            return true;
        }else {
            return false;
        }
    }

    @Override
    public List<EmployeeResponceDTO> getAll() throws Exception {

        List<EmployeeCategory>employeeCategoryList = employeeRepository.findAll();
        ArrayList<EmployeeResponceDTO>employeeResponceDTOS = new ArrayList<>();

        employeeCategoryList.forEach(each->{
            try {
                employeeResponceDTOS.add(getAllEmployee(each));
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        return employeeResponceDTOS;
    }

    @Override
    public boolean update(EmployeeResponceDTO employeeResponceDTO) throws Exception {
        EmployeeCategory employeeCategory = employeeRepository.findById(employeeResponceDTO.getEmpId()).get();
        Department department = departmentRepository.findById(employeeResponceDTO.getDepartmentResponceDTO().getDepId()).get();
        employeeCategory.setDepartment(department);
        employeeCategory.setSalary(employeeResponceDTO.getSalary());
        employeeCategory.setName(employeeResponceDTO.getName());

        if (employeeRepository.save(employeeCategory) != null){
            return true;
        }else {
            return false;
        }
    }

    private EmployeeResponceDTO employeeGet(Long empId)throws Exception{
        EmployeeResponceDTO employeeResponceDTO = new EmployeeResponceDTO();
        DepartmentResponceDTO departmentResponceDTO = new DepartmentResponceDTO();
        EmployeeCategory employeeCategory = employeeRepository.findById(empId).get();

        employeeResponceDTO.setEmpId(employeeCategory.getEmpId());
        employeeResponceDTO.setName(employeeCategory.getName());
        employeeResponceDTO.setSalary(employeeCategory.getSalary());

        departmentResponceDTO.setDepId(employeeCategory.getDepartment().getDepId());
        departmentResponceDTO.setDiscription(employeeCategory.getDepartment().getDiscription());
        employeeResponceDTO.setDepartmentResponceDTO(departmentResponceDTO);


        return employeeResponceDTO;
    }

    private EmployeeResponceDTO getAllEmployee(EmployeeCategory employeeCategory)throws Exception{

        EmployeeResponceDTO employeeResponceDTO = new EmployeeResponceDTO();
        DepartmentResponceDTO departmentResponceDTO = new DepartmentResponceDTO();

        employeeResponceDTO.setEmpId(employeeCategory.getEmpId());
        employeeResponceDTO.setName(employeeCategory.getName());
        employeeResponceDTO.setSalary(employeeCategory.getSalary());

        departmentResponceDTO.setDepId(employeeCategory.getDepartment().getDepId());
        departmentResponceDTO.setDiscription(employeeCategory.getDepartment().getDiscription());
        employeeResponceDTO.setDepartmentResponceDTO(departmentResponceDTO);

        return employeeResponceDTO;
    }
}
