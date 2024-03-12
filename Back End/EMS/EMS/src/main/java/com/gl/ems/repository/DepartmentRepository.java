package com.gl.ems.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gl.ems.entity.Department;

public interface DepartmentRepository extends JpaRepository<Department, Integer>{
	
}