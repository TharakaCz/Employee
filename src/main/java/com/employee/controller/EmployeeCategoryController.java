package com.employee.controller;

import com.employee.helper.EmployeeCategoryDTO;
import com.employee.helper.EmployeeResponceDTO;
import com.employee.service.EmployeeCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping(value = "/app/employee")
public class EmployeeCategoryController {

    @Autowired
    private EmployeeCategoryService employeeCategoryService;

    @PostMapping(value = "/save")
    protected ResponseEntity<Object>save(@RequestBody EmployeeCategoryDTO employeeCategoryDTO){
        try {
            return new ResponseEntity<Object>(employeeCategoryService.save(employeeCategoryDTO), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<Object>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "/edit/{empId}")
    protected ResponseEntity<Object>edit(@PathVariable Long empId){
        try {
            return new ResponseEntity<Object>(employeeCategoryService.edit(empId),HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<Object>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping(value = "/delete/{empId}")
    protected ResponseEntity<Object>delete(@PathVariable Long empId){
        try {
            return new ResponseEntity<Object>(employeeCategoryService.delete(empId),HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<Object>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "/getAll")
    protected ResponseEntity<Object>getAll(){
        try {
            return new ResponseEntity<Object>(employeeCategoryService.getAll(),HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<Object>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping(value = "/update")
    protected ResponseEntity<Object>update(@RequestBody EmployeeResponceDTO employeeResponceDTO){
        try {
            return new ResponseEntity<Object>(employeeCategoryService.update(employeeResponceDTO),HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<Object>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
