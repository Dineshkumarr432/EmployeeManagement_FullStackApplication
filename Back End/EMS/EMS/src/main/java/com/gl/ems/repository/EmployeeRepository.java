package com.gl.ems.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gl.ems.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

}
