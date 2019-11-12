package com.employee.controller;

import com.employee.helper.MounthlyDTO;
import com.employee.helper.MounthlyResponceDTO;
import com.employee.service.MounthlyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping(value = "/app/mounthly")
public class MounthlyController {

    @Autowired
    private MounthlyService mounthlyService;

    @PostMapping(value = "/save")
    protected ResponseEntity<Object>save(@RequestBody MounthlyDTO mounthlyDTO){

        try {
           return new ResponseEntity<Object>(mounthlyService.save(mounthlyDTO), HttpStatus.OK);
        } catch (Exception e) {
           return new ResponseEntity<Object>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
       }
    }

    @GetMapping(value = "/edit/{mounthlyId}")
    protected ResponseEntity<Object>edit(@PathVariable Long mounthlyId){
        try {
            return new ResponseEntity<Object>(mounthlyService.edit(mounthlyId),HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<Object>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping(value = "/delete/{mounthlyId}")
    protected ResponseEntity<Object>delete(@PathVariable Long mounthlyId){
        try {
            return new ResponseEntity<Object>(mounthlyService.delete(mounthlyId),HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<Object>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "/paralist")
    protected ResponseEntity<Object>getParalist(){
        try {
            return new ResponseEntity<Object>(mounthlyService.paraList(),HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<Object>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "/getAll")
    protected ResponseEntity<Object>getAll(){
        try {
            return new ResponseEntity<Object>(mounthlyService.getAll(),HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<Object>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "/calc/{salary}/{value}")
    protected ResponseEntity<Object>calculate(@PathVariable double salary,@PathVariable double value){
        try {
            return new ResponseEntity<Object>(mounthlyService.calculate(salary,value),HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<Object>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping(value = "/update")
    protected ResponseEntity<Object>update(@RequestBody MounthlyResponceDTO mounthlyResponceDTO){
        try {
            return new ResponseEntity<Object>(mounthlyService.update(mounthlyResponceDTO),HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<Object>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
