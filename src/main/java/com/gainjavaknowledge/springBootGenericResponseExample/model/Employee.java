package com.gainjavaknowledge.springBootGenericResponseExample.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Employee {

    private Long id;

    private String name;

    private Integer age;

    private Integer salary;

    private String address;
}
