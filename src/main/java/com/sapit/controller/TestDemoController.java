package com.sapit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sapit.model.Employees;

@Controller
@RequestMapping("/demo")
public class TestDemoController {
	
	@Autowired
	private Employees eee;
	
	public TestDemoController(Employees eee) {
		// TODO Auto-generated constructor stub
		this.eee = eee;
	}
	@RequestMapping("/disp")
	public void display() {
		System.out.println(eee);
	}
}
