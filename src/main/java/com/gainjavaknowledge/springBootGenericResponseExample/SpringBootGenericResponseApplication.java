package com.gainjavaknowledge.springBootGenericResponseExample;

import com.gainjavaknowledge.springBootGenericResponseExample.model.Employee;
import com.gainjavaknowledge.springBootGenericResponseExample.repository.EmployeeRepository;
import com.gainjavaknowledge.springBootGenericResponseExample.service.EmployeeService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class SpringBootGenericResponseApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootGenericResponseApplication.class, args);
	}

	@Bean
	CommandLineRunner testService(EmployeeService employeeService){
		return args ->{
			List<Employee> allEmployee = employeeService.getAllEmployee();
			System.out.println("allEmployee : "+allEmployee);
		};

	}

}
