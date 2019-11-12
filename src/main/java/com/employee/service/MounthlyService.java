package com.employee.service;

import com.employee.helper.MounthlyDTO;
import com.employee.helper.MounthlyResponceDTO;
import com.employee.helper.PayDTO;

import java.util.List;

public interface MounthlyService {

    public boolean save(MounthlyDTO mounthlyDTO)throws Exception;
    public MounthlyResponceDTO edit(Long mounthlyId)throws Exception;
    public boolean delete(Long mounthlyId)throws Exception;
    public List<PayDTO>paraList()throws Exception;
    public List<MounthlyResponceDTO>getAll()throws Exception;
    public Double calculate(double salary,double value)throws Exception;
    public boolean update(MounthlyResponceDTO mounthlyResponceDTO)throws Exception;

}
