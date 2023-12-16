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
                .status(HttpStatus.CREATED)
                .header("custome-header", "123")
                .body(GenericResponse.success(employeeService.getEmployeeName(id)," Get Name successfully."));
    }

    @GetMapping("/employee")
    public GenericResponse<List<Employee>> getAllEmployee(){
        return GenericResponse.success(employeeService.getAllEmployee());
    }

    @GetMapping("/employee/{id}")
    public Employee getEmployeeById(@PathVariable("id") Long id){
        return employeeService.getEmployeeById(id);
    }

    @PostMapping("/employee")
    public Employee addEmployee(@RequestBody Employee employee){
        return employeeService.addEmployee(employee);
    }

    @PutMapping("/employee/{id}")
    public Employee updateEmployee(@PathVariable("id") Long id, @RequestBody Employee employee){
        return employeeService.updateEmployee(id, employee);
    }

    @DeleteMapping("/employee/{id}")
    public Employee deleteEmployee(@PathVariable("id") Long id){
        return employeeService.deleteEmployee(id);
    }

}
