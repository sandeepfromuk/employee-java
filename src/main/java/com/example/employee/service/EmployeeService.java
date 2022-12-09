package com.example.employee.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.employee.dao.EmployeeDao;
import com.example.employee.entity.Employee;

@Service
public class EmployeeService {
//	List<Employee> list;
//	public EmployeeService() {
//		list=new ArrayList<>();
//		list.add(new Employee(1,"sandeep","bohra","Developer","java","2016-12-11"));
//	}
	@Autowired
	private EmployeeDao employeeDao;
	public List<Employee> getAllEmployee(){
		//return list;
		return employeeDao.findAll();
		
	}
	//get employee
	public Employee getEmployee(int  empId) throws Exception {
		return employeeDao.findById(empId).orElseThrow(() -> new Exception("ID Not Found"));
		
		
	}
	//add employee
	public Employee addEmployee(Employee employee) {
		return employeeDao.save(employee);
	}
	//update 
	public Employee updateEmployee(Employee employee) {
		return employeeDao.save(employee);
	}
	
	
	public void deleteEmployee(int empId) throws Exception {
		
		Employee employee=employeeDao.findById(empId).orElseThrow(() -> new Exception("Id Not Found"));
		employeeDao.delete(employee);
		
		
	}

	
	

}
