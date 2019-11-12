package com.employee.service.impl;

import com.employee.helper.*;
import com.employee.model.EmployeeCategory;
import com.employee.model.Mounthly;
import com.employee.repository.EmployeeRepository;
import com.employee.repository.MounthlyRepository;
import com.employee.service.MounthlyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MounthlyServiceImpl implements MounthlyService {

    @Autowired
    private MounthlyRepository mounthlyRepository;
    @Autowired
    private EmployeeRepository employeeRepository;

    @Value("${app.epf}")
    private double epf;
    @Value("${app.etf}")
    private double etf;

    @Override
    public boolean save(MounthlyDTO mounthlyDTO) throws Exception {

        Mounthly mounthly = new Mounthly();
        mounthly.setValue(mounthlyDTO.getValue());
        EmployeeCategory employeeCategory = employeeRepository.findById(mounthlyDTO.getEmployeeCategoryId()).get();
        mounthly.setEmployeeCategory(employeeCategory);

        if (mounthlyRepository.save(mounthly) != null){
            return true;
        }else {
            return false;
        }

    }

    @Override
    public MounthlyResponceDTO edit(Long mounthlyId) throws Exception {

        MounthlyResponceDTO mounthlyResponceDTO = getMounthly(mounthlyId);

        if (mounthlyResponceDTO != null){
            return mounthlyResponceDTO;
        }else {
            return null;
        }

    }

    @Override
    public boolean delete(Long mounthlyId) throws Exception {

        Optional<Mounthly>optional = mounthlyRepository.findById(mounthlyId);

        if (optional.isPresent()){
            mounthlyRepository.deleteById(mounthlyId);
            return true;
        }else{
            return false;
        }
    }

    @Override
    public List<PayDTO> paraList() throws Exception {
        ArrayList<PayDTO>paralist=new ArrayList<>();
        PayDTO pay=new PayDTO();
        pay.setName("EPF");
        pay.setValue(epf);
        paralist.add(pay);


        PayDTO payetf=new PayDTO();
        payetf.setName("ETF");
        payetf.setValue(etf);
        paralist.add(payetf);
        return paralist;
    }

    @Override
    public List<MounthlyResponceDTO> getAll() throws Exception {

        List<Mounthly>mounthlyList = mounthlyRepository.findAll();
        ArrayList<MounthlyResponceDTO>mounthlyResponceDTOS = new ArrayList<>();

        mounthlyList.forEach(each->{
            try {
                mounthlyResponceDTOS.add(getAllMounthly(each));
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        return mounthlyResponceDTOS;
    }

    @Override
    public Double calculate(double salary,double value) throws Exception {

        Double calc = salary / 100 * value;

        return calc;
    }

    @Override
    public boolean update(MounthlyResponceDTO mounthlyResponceDTO) throws Exception {

        Mounthly mounthly = mounthlyRepository.findById(mounthlyResponceDTO.getMounlyId()).get();
        EmployeeCategory employeeCategory = employeeRepository.findById(mounthlyResponceDTO.getEmployeeResponceDTO().getEmpId()).get();
        mounthly.setValue(mounthlyResponceDTO.getValue());
        mounthly.setEmployeeCategory(employeeCategory);

        if (mounthlyRepository.save(mounthly) != null){
            return  true;
        }else {
            return false;
        }

    }


    private MounthlyResponceDTO getMounthly(Long mounthlyId)throws Exception{

        MounthlyResponceDTO mounthlyResponceDTO = new MounthlyResponceDTO();
        EmployeeResponceDTO employeeCategoryDTOResponceDTO = new EmployeeResponceDTO();
        DepartmentResponceDTO departmentResponceDTO = new DepartmentResponceDTO();
        Mounthly mounthly = mounthlyRepository.findById(mounthlyId).get();

        departmentResponceDTO.setDepId(mounthly.getEmployeeCategory().getDepartment().getDepId());
        departmentResponceDTO.setDiscription(mounthly.getEmployeeCategory().getDepartment().getDiscription());

        employeeCategoryDTOResponceDTO.setEmpId(mounthly.getEmployeeCategory().getEmpId());
        employeeCategoryDTOResponceDTO.setName(mounthly.getEmployeeCategory().getName());
        employeeCategoryDTOResponceDTO.setSalary(mounthly.getEmployeeCategory().getSalary());
        employeeCategoryDTOResponceDTO.setDepartmentResponceDTO(departmentResponceDTO);

        mounthlyResponceDTO.setMounlyId(mounthly.getMounlyId());
        mounthlyResponceDTO.setValue(mounthly.getValue());


        mounthlyResponceDTO.setEmployeeResponceDTO(employeeCategoryDTOResponceDTO);

        return mounthlyResponceDTO;
    }

    private MounthlyResponceDTO getAllMounthly(Mounthly mounthly)throws Exception{

        MounthlyResponceDTO mounthlyResponceDTO = new MounthlyResponceDTO();
        EmployeeResponceDTO employeeResponceDTO = new EmployeeResponceDTO();
        DepartmentResponceDTO departmentResponceDTO = new DepartmentResponceDTO();

        mounthlyResponceDTO.setMounlyId(mounthly.getMounlyId());
        mounthlyResponceDTO.setValue(mounthly.getValue());

        departmentResponceDTO.setDepId(mounthly.getEmployeeCategory().getDepartment().getDepId());
        departmentResponceDTO.setDiscription(mounthly.getEmployeeCategory().getDepartment().getDiscription());

        employeeResponceDTO.setEmpId(mounthly.getEmployeeCategory().getEmpId());
        employeeResponceDTO.setSalary(mounthly.getEmployeeCategory().getSalary());
        employeeResponceDTO.setName(mounthly.getEmployeeCategory().getName());

        employeeResponceDTO.setDepartmentResponceDTO(departmentResponceDTO);

        mounthlyResponceDTO.setEmployeeResponceDTO(employeeResponceDTO);

        return mounthlyResponceDTO;
    }
}
