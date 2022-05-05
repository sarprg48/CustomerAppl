package com.sapit.service;

import java.util.List;

import com.sapit.model.Employees;

public interface EmployeeService {
	public Employees saveEmployee(Employees employee);
	public List<Employees> getAllEmployees();
	public Employees getEmployee(long id);
	public Employees updateEmployee(long id,Employees emp) ;
	public void deleteEmployee(long id) ;
	
	
}
