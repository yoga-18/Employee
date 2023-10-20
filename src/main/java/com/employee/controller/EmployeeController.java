package com.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.employee.customexception.IdNotFoundException;
import com.employee.customexception.SalaryNotValidException;
import com.employee.entity.Employee;
import com.employee.service.EmployeeService;

@RestController
public class EmployeeController {
	
	@Autowired
	EmployeeService es;
	
	@PostMapping(path="/setValue")
	public String setSingle(@RequestBody Employee x) {
		return es.setSingle(x);
	}
	@PostMapping(path="/setA")
	public String setAll(@RequestBody List<Employee> a) {
		return es.setAll(a);
	}
	public List<Employee> getAll(){
		return es.getAll();
	}
	@PostMapping(path="/setSal")
	public String setSalary(@RequestBody List<Employee> y)throws SalaryNotValidException {
		return es.setSalary(y);
	}
	@GetMapping(path="/getId/{b}")
	public Employee getId(@PathVariable int b) throws IdNotFoundException {
		return es.getId(b);
	}
	@GetMapping(path="/getIncSal")
	public List<Employee> getIncSal() {
		return es.getIncSal();
	}

}
