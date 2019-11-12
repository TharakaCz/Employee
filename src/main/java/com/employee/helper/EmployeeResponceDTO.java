package com.employee.helper;

public class EmployeeResponceDTO {

    private Long empId;
    private String name;
    private DepartmentResponceDTO departmentResponceDTO;
    private double salary;

    public EmployeeResponceDTO() {
    }

    public Long getEmpId() {
        return empId;
    }

    public void setEmpId(Long empId) {
        this.empId = empId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public DepartmentResponceDTO getDepartmentResponceDTO() {
        return departmentResponceDTO;
    }

    public void setDepartmentResponceDTO(DepartmentResponceDTO departmentResponceDTO) {
        this.departmentResponceDTO = departmentResponceDTO;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
