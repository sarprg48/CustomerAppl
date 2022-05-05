package com.sapit.service.impl;


import java.util.List;
import java.util.Optional;

import org.springframework.context.annotation.Primary;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.sapit.EmployeeRepositary;
import com.sapit.ResourceNotFoundException;
import com.sapit.model.Employees;
import com.sapit.service.EmployeeService;

@Service
@Primary
public class EmployeeServiceImpl implements EmployeeService{
	
	EmployeeRepositary employeeRepo; 

	public EmployeeServiceImpl(EmployeeRepositary employeeRepo) {
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
		  
//		 System.out.println("emp id--->"+id);
		String dat = null;
		System.out.println(dat.equals("hi"));
		Optional<Employees> opt = employeeRepo.findById(id);
		if(!opt.isPresent()) {
			throw new ResourceNotFoundException(HttpStatus.NOT_FOUND, "data not found");
		}
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
//		Employees empOne = employeeRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employees", "id", id));
		Employees empOne =  employeeRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException(HttpStatus.NOT_FOUND, "data not found"));
		employeeRepo.deleteById(empOne.getId());
	}

}
