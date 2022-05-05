package com.sapit;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sapit.model.Employees;

public interface EmployeeRepositary extends JpaRepository<Employees, Long>{

}
