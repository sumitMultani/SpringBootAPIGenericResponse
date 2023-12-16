package com.gainjavaknowledge.springBootGenericResponseExample.service.impl;

import com.gainjavaknowledge.springBootGenericResponseExample.entity.EmployeeEntity;
import com.gainjavaknowledge.springBootGenericResponseExample.mapper.EmployeeMapper;
import com.gainjavaknowledge.springBootGenericResponseExample.model.Employee;
import com.gainjavaknowledge.springBootGenericResponseExample.repository.EmployeeRepository;
import com.gainjavaknowledge.springBootGenericResponseExample.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private EmployeeMapper employeeMapper;

    @Override
    public List<Employee> getAllEmployee() {
        List<EmployeeEntity> employees = employeeRepository.findAll();
        List<Employee> employeeResponse = new ArrayList<>();
        if(!CollectionUtils.isEmpty(employees)){
            employeeResponse = employees.stream()
                    .map(emp -> new Employee(emp.getId(), emp.getName(), emp.getAge(),emp.getSalary(), emp.getAddress()))
                    .collect(Collectors.toList());
        }
        return employeeResponse;
    }

    @Override
    public Employee addEmployee(Employee employee) {
        EmployeeEntity empEntity = employeeRepository.save(employeeMapper.getEmployeeEntityFromModel(employee));
        return employeeMapper.getEmployeeModelFromEntity(empEntity);
    }

    @Override
    public Employee getEmployeeById(Long id) {
        Optional<EmployeeEntity> empOpt = employeeRepository.findById(id);
        if(empOpt.isPresent())
              return employeeMapper.getEmployeeModelFromEntity(empOpt.get());
        return null;
    }

    @Override
    public Employee updateEmployee(Long id, Employee employee) {
        Optional<EmployeeEntity> empOpt = employeeRepository.findById(id);
        if(empOpt.isPresent()) {
            EmployeeEntity empEntity = empOpt.get();
            if(employee.getName() != null && !employee.getName().isEmpty())
                empEntity.setName(employee.getName());
            if(employee.getAddress() != null && !employee.getAddress().isEmpty())
                empEntity.setAddress(employee.getAddress());
            if(employee.getAge() != null && !employee.getAge().equals(0))
                empEntity.setAge(employee.getAge());
            if(employee.getSalary() != null && !employee.getSalary().equals(0))
                empEntity.setSalary(employee.getSalary());
            EmployeeEntity empEntityRes = employeeRepository.save(empEntity);
            return employeeMapper.getEmployeeModelFromEntity(empEntityRes);
        }
        return null;
    }

    @Override
    public Employee deleteEmployee(Long id) {
        Optional<EmployeeEntity> empOpt = employeeRepository.findById(id);
        if(empOpt.isPresent())
            return employeeMapper.getEmployeeModelFromEntity(empOpt.get());
        return null;
    }

    @Override
    public String getEmployeeName(Long id) {
        Optional<EmployeeEntity> empOpt = employeeRepository.findById(id);
        if(empOpt.isPresent())
            return empOpt.get().getName();
        return null;
    }

}
