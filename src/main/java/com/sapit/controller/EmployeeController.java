package com.sapit.controller;

import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder.BCryptVersion;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sapit.aop.CentralAopForLogger;
import com.sapit.model.Employees;
import com.sapit.service.EmployeeService;
import com.sapit.service.impl.EmployeeServiceImpl;

@RestController
@RequestMapping("/api/emp")
public class EmployeeController {
	
//	/emp
//	private org.slf4j.Logger log=LoggerFactory.getLogger(EmployeeController.class);

	@Autowired
//	@Primary(1)
	@Qualifier("employeeServiceImpl")
	EmployeeService employeeService;
	
	
	public EmployeeController(EmployeeService employeeService) {
//		super();
		this.employeeService = employeeService;
	}
	
	@GetMapping(path = "/")
	public ResponseEntity<String> entryForm() {
		return new ResponseEntity<String>("Welcome", HttpStatus.OK);
	}
	
	@GetMapping(path = "/hello")
	public String helloWorld() {
		return "Hello juint test welcome to world";
	}

	@RequestMapping(path = "/insert",method = RequestMethod.POST)
	public ResponseEntity<Employees> saveEmployee(@RequestBody Employees emp) {
		return new ResponseEntity<Employees>(employeeService.saveEmployee(emp), HttpStatus.CREATED);
	}
	
	@GetMapping("/fetchall")
	public ResponseEntity<List<Employees>> getAllEmployees() {
//		return empSericeImpl.getAllEmployees();
		return new ResponseEntity<List<Employees>>(employeeService.getAllEmployees(), HttpStatus.OK);
	}
	
	@GetMapping("/single/{id}")
	public ResponseEntity<Employees> getEmployee(@PathVariable("id") long id) {
//		return empSericeImpl.getAllEmployees();
//		System.out.println("id--->"+id);
		return new ResponseEntity<Employees>(employeeService.getEmployee(id), HttpStatus.OK);
	}
	
	@PutMapping("/updbyid/{id}")
	public ResponseEntity<Employees> updateEmployee(@PathVariable("id") long id,@RequestBody Employees emp) {
//		return empSericeImpl.getAllEmployees();
		return new ResponseEntity<Employees>(employeeService.updateEmployee(id, emp), HttpStatus.OK);
	}
	
	
	@DeleteMapping("/delbyid/{id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable("id") long id) {
		employeeService.deleteEmployee(id);
		return new ResponseEntity<String>("Employee deleted successfully", HttpStatus.OK);
	}
	
	
	
//	 public static void encodePwd() { 
//		 String rawPassword = "java2020"; String
//	  encodedPassword = null;
////	  BCryptPasswordEncoder bp = new BCryptPasswordEncoder(); //
//	  BCryptPasswordEncoder bp = new BCryptPasswordEncoder(BCryptVersion.$2B,7);
//	  
//	  for (int i = 0; i < 2; i++) {
//		  encodedPassword = bp.encode(rawPassword);
//	  System.out.println(encodedPassword); 
//	  boolean matched =
//	  bp.matches(rawPassword, encodedPassword); 
//	  System.out.println(matched);
//	  boolean matched1 = bp.matches("$2b$07$Pl9hChHeU6fuCWAzxz62x.189nji5iLf20amK0zwW1wRkzuylnKce", encodedPassword);
//	  System.out.println("hello--->"+matched1); }
//	  }
//	  
//	  
//	  public static void main(String[] args) { encodePwd(); }
	 
	
}
