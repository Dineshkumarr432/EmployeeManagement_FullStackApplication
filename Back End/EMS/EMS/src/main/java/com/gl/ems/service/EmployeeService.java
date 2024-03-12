package com.gl.ems.service;

import java.util.List;

import com.gl.ems.dto.EmployeeDTO;
import com.gl.ems.entity.Employee;

public interface EmployeeService {
	 EmployeeDTO createEmployee(EmployeeDTO dto);
	 EmployeeDTO getEmployeeById(int id);
	 EmployeeDTO updateEmployeeById(int id,EmployeeDTO dto);
	 List<EmployeeDTO> getAllEmployees();
	 void deleteEmployeeById(int id);
}
