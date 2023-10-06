package com.example.hr.repository;
import java.util.List;

import com.example.hr.model.Employee;

public interface EmployeeReps {
	int count();
	Employee findEmp(Long id);
	List<Employee> findAll();
	int  insert(Employee emp);
	int update(Employee emp);
	int delete(Long id);
 }
