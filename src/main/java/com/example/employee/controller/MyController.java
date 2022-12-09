package com.example.employee.controller;

import java.util.List;

import org.hibernate.jdbc.Expectations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.employee.entity.Employee;
import com.example.employee.service.EmployeeService;

@RestController
public class MyController {


	@Autowired
	private EmployeeService employeeService;
	
	//get all employee
	@GetMapping("/employee")
	public List<Employee> Employees(){
		return this.employeeService.getAllEmployee();
		
	}
	@GetMapping("/employee/{empid}")
	public Employee getEmployee(@PathVariable int empid) throws Exception{
		return this.employeeService.getEmployee(empid);
		
	}
	//post
	@PostMapping("/employee")
	public Employee addEmployee(@RequestBody Employee employee) {
		return employeeService.addEmployee(employee);
		
		
	}
	//update employee
	@PutMapping("/employee")
	public Employee updateEmployee(@RequestBody Employee employee) {
		return employeeService.updateEmployee(employee);
		
	}
	//delete course
	@DeleteMapping("/employee/{empId}")
	public  ResponseEntity<String> deleteEmployee(@PathVariable String empId) {
		try {
//			/@GetMapping("/hello")
//			ResponseEntity<String> hello() {
//			    return new ResponseEntity<>("Hello World!", HttpStatus.OK);
//			}
			
			this.employeeService.deleteEmployee(Integer.parseInt(empId));
			return new ResponseEntity<>("Employee delete successfully!!!",HttpStatus.OK);
			
		}
		catch (Exception e ) {
			return new ResponseEntity<>("Employee not found !!!",HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
		
		
	}
	
	

}
