package com.gainjavaknowledge.springBootGenericResponseExample.repository;

import com.gainjavaknowledge.springBootGenericResponseExample.entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Long> {

    List<EmployeeEntity> findByName(@Param("name") String name);
}
