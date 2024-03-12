package com.gl.ems.service;

import java.util.List;

import com.gl.ems.dto.DepartmentDTO;
import com.gl.ems.entity.Department;

public interface DepartmentService {
	DepartmentDTO createDepartment(DepartmentDTO dto);
	DepartmentDTO getDepartmentById(int id);
	DepartmentDTO updateDepartmentById(int id, DepartmentDTO dto);
	List<DepartmentDTO> getAllDepartments();
	void deleteDepartmentById(int id);
}