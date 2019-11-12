package com.employee.helper;

public class MounthlyResponceDTO {

    private Long mounlyId;
    private double value;
    private EmployeeResponceDTO employeeResponceDTO;

    public MounthlyResponceDTO() {
    }

    public Long getMounlyId() {
        return mounlyId;
    }

    public void setMounlyId(Long mounlyId) {
        this.mounlyId = mounlyId;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public EmployeeResponceDTO getEmployeeResponceDTO() {
        return employeeResponceDTO;
    }

    public void setEmployeeResponceDTO(EmployeeResponceDTO employeeResponceDTO) {
        this.employeeResponceDTO = employeeResponceDTO;
    }
}
