package com.gl.ems.dto;

import com.gl.ems.entity.Department;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDTO {
	int id;
	String firstName;
	String lastName;
	String email;
	Department department;
}
