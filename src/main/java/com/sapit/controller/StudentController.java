package com.sapit.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sapit.model.Student;

@RestController
public class StudentController {
	
//	@GetMapping("/student")
	@RequestMapping(path = "/student",method = RequestMethod.GET)
	public Student getStudent() {
		return new Student("sai", "prasad");
	}
	
	@GetMapping("/students")
	public List<Student> getStudents() {
		return Arrays.asList(new Student("sai", "prasad"),new Student("divya", "bharathi"),new Student("hansini", "BH"),new Student("taswik", "bh"));
	}
	
	@GetMapping("/student/{fName}/{lName}")
	public Student getStudentOnPathVariable(@PathVariable("fName")String firstName,@PathVariable("lName")String lastName) {
		return new Student(firstName, lastName);
	}
	
	@GetMapping("/studentby")
	public Student getStudentOnQuery(@RequestParam(name = "fName")String firstName,@RequestParam(name = "lName")String lastName) {
		return new Student(firstName, lastName);
	}
	
}
