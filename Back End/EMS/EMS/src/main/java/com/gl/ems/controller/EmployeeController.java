package com.gl.ems.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

import com.gl.ems.dto.EmployeeDTO;
import com.gl.ems.entity.Employee;
import com.gl.ems.serviceImpl.EmployeeServiceImpl;

@CrossOrigin("*")//When a web page makes a request for a resource (like an image, script, or data) from a different origin (i.e., a different domain, protocol, or port), it's considered a cross-origin request. Browsers have security policies in place to prevent certain types of cross-origin requests, as they can pose security risks such as cross-site request forgery (CSRF) and leaking sensitive data.
@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
	@Autowired
	EmployeeServiceImpl empService;
	
	@PostMapping
	ResponseEntity <EmployeeDTO> createEmployee(@RequestBody EmployeeDTO empDTO){
		EmployeeDTO e = empService.createEmployee(empDTO);
		return new ResponseEntity(e,HttpStatus.CREATED);
	} 
	
	@GetMapping("{id}")
	ResponseEntity<EmployeeDTO> getEmployeeById(@PathVariable int id){
		EmployeeDTO e = empService.getEmployeeById(id);
		return new ResponseEntity(e,HttpStatus.OK);
	}
	
	@PutMapping("{id}")
	ResponseEntity<EmployeeDTO> updateEmployeeById(@PathVariable int id,@RequestBody EmployeeDTO employeeDTO){
		EmployeeDTO e = empService.updateEmployeeById(id, employeeDTO);
		return new ResponseEntity(e,HttpStatus.OK);
	}
	
	@DeleteMapping("{id}")
	ResponseEntity<EmployeeDTO> deleteEmployeeById(@PathVariable int id){
		empService.deleteEmployeeById(id);
		return new ResponseEntity("Employee deleted successfullt",HttpStatus.OK);
	}
	
	@GetMapping
	ResponseEntity <List<EmployeeDTO>> getAllEmployees(){
		List<EmployeeDTO> e = empService.getAllEmployees();
		return new ResponseEntity(e,HttpStatus.OK);
	}
	
}