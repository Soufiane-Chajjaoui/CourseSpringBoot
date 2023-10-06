package com.example.hr.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.hr.model.Employee;
import com.example.hr.repository.EmployeeReps;

import jakarta.websocket.server.PathParam;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

	@Autowired
	private EmployeeReps EmpReps;


	@GetMapping("/count")
	public int countEmployee() {
		return EmpReps.count();
	}
	
	@GetMapping("/getEmployee/{id}")
	public Employee getEmployee(@PathVariable Long id) {
		return EmpReps.findEmp(id);
	}

	@GetMapping("/allEmployees")
	public List<Employee> getEmployee() {
		return EmpReps.findAll();
	}
 
	@PostMapping("/insert")
	public ResponseEntity<String> insertEmp(@RequestBody Employee emp){
		
		if (EmpReps.insert(emp) > 0) {
			return ResponseEntity.ok("data inserted successfully");
		}else return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error inserting data");
	}
	
	@PutMapping("/update")
	public ResponseEntity<String> updateEmp(@RequestBody Employee emp) {
		if (EmpReps.update(emp) > 0) {
			return ResponseEntity.ok("Employee Update successfully");
		}else return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error inserting data");
	}
	
	@DeleteMapping("/delete")
	public ResponseEntity<String> deleteEmp(@RequestParam Long id){
		
		if (EmpReps.delete(id) > 0) {
            return ResponseEntity.status(HttpStatus.OK).body("Employee deleted successfully");		
            }else return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error Removing data");
	}
}
