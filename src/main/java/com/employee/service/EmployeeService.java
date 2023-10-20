package com.employee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.customexception.IdNotFoundException;
import com.employee.customexception.SalaryNotValidException;
import com.employee.dao.EmployeeDao;
import com.employee.entity.Employee;
import com.employee.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	EmployeeDao ed;
	@Autowired
	EmployeeRepository er;
	
	public String setAll(List<Employee> b) {
		return ed.setAll(b);
	}
	public String setSingle(Employee y) {
		return ed.setSingle(y);
	}
	public List<Employee> getAll(){
		return ed.getAll();
	}
	public String setSalary(List<Employee> z)throws SalaryNotValidException{
		List<Employee> ab = z.stream().filter(a->a.getSalary()>50000).toList();
		if(ab.isEmpty()) {
			throw new SalaryNotValidException("No Values Present");
		}
		else {
			return ed.setSalary(ab);
		}
	}

	public Employee getId(int c)throws IdNotFoundException {
		
		return ed.getId(c);
		}
	public List<Employee> getIncSal() {
		List<Employee> ac = getAll();
		List<Employee> ad = ac.stream().filter(x->x.getShift().equalsIgnoreCase("night")).peek(y->y.setSalary(y.getSalary()+(y.getSalary()*20/100))).toList();
		return ad;
	}
}
