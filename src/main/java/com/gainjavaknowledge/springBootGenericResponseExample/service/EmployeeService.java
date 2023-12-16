package com.gainjavaknowledge.springBootGenericResponseExample.service;

import com.gainjavaknowledge.springBootGenericResponseExample.model.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> getAllEmployee();

    Employee addEmployee(Employee employee);

    Employee getEmployeeById(Long id);

    Employee updateEmployee(Long id, Employee employee);

    Employee deleteEmployee(Long id);

    String getEmployeeName(Long id);
}
