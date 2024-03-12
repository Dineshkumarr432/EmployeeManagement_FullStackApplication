package com.gl.ems.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gl.ems.dto.DepartmentDTO;
import com.gl.ems.entity.Department;
import com.gl.ems.serviceImpl.DepartmentServiceImpl;

@CrossOrigin("*") //When a web page makes a request for a resource (like an image, script, or data) from a different origin (i.e., a different domain, protocol, or port), it's considered a cross-origin request. Browsers have security policies in place to prevent certain types of cross-origin requests, as they can pose security risks such as cross-site request forgery (CSRF) and leaking sensitive data.
@RestController
@RequestMapping("/api/departments")
public class DepartmentController {
	
	@Autowired
	 DepartmentServiceImpl depService;
	
	// Build Create or Add Department REST API
	@PostMapping
	ResponseEntity <DepartmentDTO> createDepartment (@RequestBody DepartmentDTO dto){
		depService.createDepartment(dto);
		return new ResponseEntity<>(dto, HttpStatus.CREATED);
	}
	
	
	// Build Get Department REST API
	@GetMapping("{id}")
	ResponseEntity <DepartmentDTO> getDepartmentById(@PathVariable("id") int id){
		DepartmentDTO dto=depService.getDepartmentById(id);
		return new ResponseEntity<>(dto,HttpStatus.OK);
	}
	
	// Build Update Departments By ID REST API
	@PutMapping("{id}")
	ResponseEntity <DepartmentDTO> updateDepartmentById(@PathVariable("id") int id ,@RequestBody DepartmentDTO dto){
		DepartmentDTO d = depService.updateDepartmentById(id, dto);
		return new ResponseEntity(d,HttpStatus.OK);
	}
	
	// Build Delete Department By Id REST API
	@DeleteMapping("{id}")
	ResponseEntity <DepartmentDTO> deleteById(@PathVariable("id") int id){
		depService.deleteDepartmentById(id);
		return new ResponseEntity("department delete successfully",HttpStatus.OK);
	}
	
	// Build Get All Departments
	@GetMapping
	ResponseEntity <List<DepartmentDTO>> getAllDepartments(){
		List<DepartmentDTO> list = depService.getAllDepartments();
		return new ResponseEntity(list,HttpStatus.OK);
	}
}
