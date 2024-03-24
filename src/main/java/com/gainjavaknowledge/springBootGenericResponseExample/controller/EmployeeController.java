package com.gainjavaknowledge.springBootGenericResponseExample.controller;

import com.gainjavaknowledge.springBootGenericResponseExample.model.Employee;
import com.gainjavaknowledge.springBootGenericResponseExample.model.GenericResponse;
import com.gainjavaknowledge.springBootGenericResponseExample.service.EmployeeService;
import com.gainjavaknowledge.springBootGenericResponseExample.service.impl.EmployeeServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeController.class);

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employee/name/{id}")
    public ResponseEntity<GenericResponse<String>> getEmployeeName(@PathVariable("id") Long id){
        LOGGER.info("Inside EmployeeController getEmployeeName method.");
        return ResponseEntity
                .status(HttpStatus.OK)
                .header("custome-header", "123")
                .body(GenericResponse.success(employeeService.getEmployeeName(id)," Get Name successfully."));
    }

    @GetMapping("/employee")
    public ResponseEntity<GenericResponse<List<Employee>>> getAllEmployee(){
        LOGGER.info("START ==> LOG 1 : Inside EmployeeController getAllEmployee method.");
        return ResponseEntity
                .status(HttpStatus.OK)
                .header("custome-header", "value")
                .body(GenericResponse.success(employeeService.getAllEmployee()," Get all employee successfully."));

    }

    @GetMapping("/employee/{id}")
    public ResponseEntity<GenericResponse<Employee>> getEmployeeById(@PathVariable("id") Long id){
        LOGGER.info("Inside EmployeeController getEmployeeById method.");
        return ResponseEntity
                .status(HttpStatus.OK)
                .header("custome-header", "value")
                .body(GenericResponse.success(employeeService.getEmployeeById(id)," Get employee successfully."));
    }

    @PostMapping("/employee")
    public ResponseEntity<GenericResponse<Employee>> addEmployee(@RequestBody Employee employee){
        LOGGER.info("Inside EmployeeController addEmployee method.");
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .header("custome-header", "value")
                .body(GenericResponse.success(employeeService.addEmployee(employee),"Created employee successfully."));
    }

    @PutMapping("/employee/{id}")
    public ResponseEntity<GenericResponse<Employee>> updateEmployee(@PathVariable("id") Long id, @RequestBody Employee employee){
        LOGGER.info("Inside EmployeeController updateEmployee method.");
        return ResponseEntity
                .status(HttpStatus.OK)
                .header("custome-header", "value")
                .body(GenericResponse.success(employeeService.updateEmployee(id, employee),"Updated employee successfully."));
    }

    @DeleteMapping("/employee/{id}")
    public ResponseEntity<GenericResponse<Employee>> deleteEmployee(@PathVariable("id") Long id){
        LOGGER.info("Inside EmployeeController deleteEmployee method.");
        return ResponseEntity
                .status(HttpStatus.OK)
                .header("custome-header", "value")
                .body(GenericResponse.success(employeeService.deleteEmployee(id),"Deleted employee successfully."));
    }

}
