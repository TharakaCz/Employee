package com.employee.controller;

import com.employee.helper.DepartmentDTO;
import com.employee.helper.DepartmentResponceDTO;
import com.employee.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping(value = "/app/department")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @PostMapping(value = "/save")
    protected ResponseEntity<Object>save(@RequestBody DepartmentDTO departmentDTO){
        try {
            return new ResponseEntity<Object>(departmentService.save(departmentDTO), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<Object>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "/edit/{depId}")
    protected ResponseEntity<Object>edit(@PathVariable Long depId){
        try {
            return new ResponseEntity<Object>(departmentService.edit(depId),HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<Object>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping(value = "/delete/{empId}")
    protected ResponseEntity<Object>delete(@PathVariable Long depId){
        try {
            return new ResponseEntity<Object>(departmentService.delete(depId),HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<Object>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "/getAll")
    protected ResponseEntity<Object>getAll(){
        try {
            return new ResponseEntity<Object>(departmentService.getAll(),HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<Object>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping(value = "/update")
    protected  ResponseEntity<Object>update(@RequestBody DepartmentResponceDTO departmentResponceDTO){
        try {
            return new ResponseEntity<Object>(departmentService.update(departmentResponceDTO),HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<Object>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
