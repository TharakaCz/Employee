package com.employee.model;

import javax.persistence.*;

@Entity
@Table(name = "MOUNTHLY")
public class Mounthly {

    private Long mounlyId;
    private EmployeeCategory employeeCategory;
    private double value;

    public Mounthly() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PID",length = 100)
    public Long getMounlyId() {
        return mounlyId;
    }

    public void setMounlyId(Long mounlyId) {
        this.mounlyId = mounlyId;
    }

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "EMPLOYEE_CATEGORY")
    public EmployeeCategory getEmployeeCategory() {
        return employeeCategory;
    }

    public void setEmployeeCategory(EmployeeCategory employeeCategory) {
        this.employeeCategory = employeeCategory;
    }

    @Column(name = "VALUE",nullable = false)
    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }
}
