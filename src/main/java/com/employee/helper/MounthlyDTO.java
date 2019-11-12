package com.employee.helper;

public class MounthlyDTO {

    private Long employeeCategoryId;
    private double value;



    public MounthlyDTO() {
    }

    public Long getEmployeeCategoryId() {
        return employeeCategoryId;
    }

    public void setEmployeeCategoryId(Long employeeCategoryId) {
        this.employeeCategoryId = employeeCategoryId;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }
}
