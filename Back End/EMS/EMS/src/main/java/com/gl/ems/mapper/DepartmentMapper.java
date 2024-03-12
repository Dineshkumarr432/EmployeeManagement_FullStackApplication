package com.gl.ems.mapper;

import com.gl.ems.dto.DepartmentDTO;
import com.gl.ems.entity.Department;

public class DepartmentMapper {
	public static DepartmentDTO mapToDepartmentDTO(Department department) {
		DepartmentDTO dto = new DepartmentDTO(department.getId(), department.getDepartmentName(),
				department.getDepartmentDescription());
		return dto;
	}

	public static Department mapToDepartment(DepartmentDTO departmentDTO) {
		Department dep = new Department(departmentDTO.getId(), departmentDTO.getDepartmentName(),
				departmentDTO.getDepartmentDescription());
		return dep;
	}
}