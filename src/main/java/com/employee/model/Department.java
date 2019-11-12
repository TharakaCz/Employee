package com.employee.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "DEPARTMENT")
public class Department {

    private Long depId;
    private String discription;
    private List<EmployeeCategory>employeeCategories;

    public Department() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PID",length = 100)
    public Long getDepId() {
        return depId;
    }

    public void setDepId(Long depId) {
        this.depId = depId;
    }

    @Column(name = "DISCRIPTION",length = 255,nullable = false)
    public String getDiscription() {
        return discription;
    }

    public void setDiscription(String discription) {
        this.discription = discription;
    }

    @OneToMany(mappedBy = "department",targetEntity = EmployeeCategory.class)
    public List<EmployeeCategory> getEmployeeCategories() {
        return employeeCategories;
    }

    public void setEmployeeCategories(List<EmployeeCategory> employeeCategories) {
        this.employeeCategories = employeeCategories;
    }
}
