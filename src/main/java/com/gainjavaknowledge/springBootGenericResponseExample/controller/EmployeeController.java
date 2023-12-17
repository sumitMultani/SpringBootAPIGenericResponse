package com.gainjavaknowledge.springBootGenericResponseExample.controller;

import com.gainjavaknowledge.springBootGenericResponseExample.model.Employee;
import com.gainjavaknowledge.springBootGenericResponseExample.model.GenericResponse;
import com.gainjavaknowledge.springBootGenericResponseExample.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employee/name/{id}")
    public ResponseEntity<GenericResponse<String>> getEmployeeName(@PathVariable("id") Long id){
        return ResponseEntity
                .status(HttpStatus.OK)
                .header("custome-header", "123")
                .body(GenericResponse.success(employeeService.getEmployeeName(id)," Get Name successfully."));
    }

    @GetMapping("/employee")
    public ResponseEntity<GenericResponse<List<Employee>>> getAllEmployee(){
        return ResponseEntity
                .status(HttpStatus.OK)
                .header("custome-header", "value")
                .body(GenericResponse.success(employeeService.getAllEmployee()," Get all employee successfully."));

    }

    @GetMapping("/employee/{id}")
    public ResponseEntity<GenericResponse<Employee>> getEmployeeById(@PathVariable("id") Long id){
        return ResponseEntity
                .status(HttpStatus.OK)
                .header("custome-header", "value")
                .body(GenericResponse.success(employeeService.getEmployeeById(id)," Get employee successfully."));
    }

    @PostMapping("/employee")
    public ResponseEntity<GenericResponse<Employee>> addEmployee(@RequestBody Employee employee){
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .header("custome-header", "value")
                .body(GenericResponse.success(employeeService.addEmployee(employee),"Created employee successfully."));
    }

    @PutMapping("/employee/{id}")
    public ResponseEntity<GenericResponse<Employee>> updateEmployee(@PathVariable("id") Long id, @RequestBody Employee employee){
        return ResponseEntity
                .status(HttpStatus.OK)
                .header("custome-header", "value")
                .body(GenericResponse.success(employeeService.updateEmployee(id, employee),"Updated employee successfully."));
    }

    @DeleteMapping("/employee/{id}")
    public ResponseEntity<GenericResponse<Employee>> deleteEmployee(@PathVariable("id") Long id){
        return ResponseEntity
                .status(HttpStatus.OK)
                .header("custome-header", "value")
                .body(GenericResponse.success(employeeService.deleteEmployee(id),"Deleted employee successfully."));
    }

}
