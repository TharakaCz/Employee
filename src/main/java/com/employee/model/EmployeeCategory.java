package com.employee.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "EMPLOYEECATEGORY")
public class EmployeeCategory {

    private Long empId;
    private String name;
    private Department department;
    private double salary;
    private List<Mounthly>mounthlies;

    public EmployeeCategory() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PID",length = 100)
    public Long getEmpId() {
        return empId;
    }

    public void setEmpId(Long empId) {
        this.empId = empId;
    }

    @Column(name = "NAME",nullable = false,length = 255)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "DEPARTMENT")
    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    @Column(name = "SALARY",nullable = false,length = 255)
    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @OneToMany(mappedBy = "employeeCategory",targetEntity = Mounthly.class)
    public List<Mounthly> getMounthlies() {
        return mounthlies;
    }

    public void setMounthlies(List<Mounthly> mounthlies) {
        this.mounthlies = mounthlies;
    }
}
