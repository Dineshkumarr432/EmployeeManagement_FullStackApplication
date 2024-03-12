package com.gl.ems.mapper;

import com.gl.ems.dto.EmployeeDTO;
import com.gl.ems.entity.Employee;

public class EmployeeMapper {
	public static EmployeeDTO mapToEmployeeDTO(Employee employee) {
		EmployeeDTO dto= new EmployeeDTO(employee.getId(),employee.getFirstName(),employee.getLastName(),employee.getEmail(),employee.getDepartment());
		return dto;
	}
	
	public static Employee mapToEmployee(EmployeeDTO dto) {
		Employee emp = new Employee(dto.getId(),dto.getFirstName(),dto.getLastName(),dto.getEmail(),dto.getDepartment());
		return emp;
	}
}
