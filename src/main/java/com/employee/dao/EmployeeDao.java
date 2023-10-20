package com.employee.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.employee.customexception.IdNotFoundException;
import com.employee.entity.Employee;
import com.employee.repository.EmployeeRepository;

@Repository
public class EmployeeDao {
	@Autowired
	EmployeeRepository er;
	
	public String setAll(List<Employee> c) {
		er.saveAll(c);
		return "Datas Added";
	}
	public String setSingle(Employee z) {
		er.save(z);
		return "Single Data Added";
	}
	public List<Employee> getAll(){
		return er.findAll();
	}
	public String setSalary(List<Employee> c) {
		er.saveAll(c);
		return "Datas Added";
	}
	public Employee getId(int c)throws IdNotFoundException{
		return er.findById(c).orElseThrow(()->new IdNotFoundException("Not a proper Id"));
	}
	
	
	
}
