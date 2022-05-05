package com.sapit.service.impl;


import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.sapit.EmployeeRepositary;
import com.sapit.ResourceNotFoundException;
import com.sapit.model.Employees;
import com.sapit.service.EmployeeService;

@Service
public class EmployeeServiceImpl2 implements EmployeeService{
	
	EmployeeRepositary employeeRepo; 

	public EmployeeServiceImpl2(EmployeeRepositary employeeRepo) {
		super();
		this.employeeRepo = employeeRepo;
	}


	@Override
	public Employees saveEmployee(Employees employee) {
		// TODO Auto-generated method stub
		return employeeRepo.save(employee);
	}


	@Override
	public List<Employees> getAllEmployees() {
		// TODO Auto-generated method stub
		return employeeRepo.findAll();
	}


	@Override
	public Employees getEmployee(long id) {
		// TODO Auto-generated method stub
		
//		  Optional<Employees> optObj = employeeRepo.findById(id);
//		  if(optObj.isPresent()) { return optObj.get(); }
//			  return null;
		  
		 System.out.println("emp id--->"+id);
		return employeeRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employees", "id", id));
	}


	@Override
	public Employees updateEmployee(long id, Employees emp) {
		// TODO Auto-generated method stub
		
		Employees empOne = employeeRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employees", "id", id));
			empOne.setFirstName(emp.getFirstName());
			empOne.setLastName(emp.getLastName());
			empOne.setEmail(emp.getEmail());
			employeeRepo.save(empOne);
		return empOne;
	}


	@Override
	public void deleteEmployee(long id) {
		// TODO Auto-generated method stub
		Employees empOne =  employeeRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employees", "id", id));
		employeeRepo.deleteById(empOne.getId());
	}

}
