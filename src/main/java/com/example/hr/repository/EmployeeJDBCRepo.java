package com.example.hr.repository;

 import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.example.hr.Mapper.EmployeeRowMapper;
import com.example.hr.model.Employee;

@Repository
@Primary
public class EmployeeJDBCRepo implements EmployeeReps {
	
	@Autowired
	private JdbcTemplate jdbcTemp ;

	@Override
	public int count() {
 		return jdbcTemp.queryForObject("select count(*) from employees" , Integer.class);
	}

 	@SuppressWarnings("deprecation")
	public Employee findEmp(Long id) {
 		return 
				jdbcTemp.queryForObject("select id , name , salary from employees WHERE id = ?", new Object[] {id}, new EmployeeRowMapper() );
	}
 
 	@Override
	public List<Employee> findAll() {
 		return 			
				 jdbcTemp.query("select * from employees",  new EmployeeRowMapper() );

	} 

	@Override
	public int insert(Employee emp) {
 		return jdbcTemp.update("insert into employees (id , name , salary) values (? , ? , ? ) " , emp.getId() ,emp.getName(), emp.getSalary());
	}

	@Override
	public int update(Employee emp) {
		// TODO Auto-generated method stub
		return 
				jdbcTemp.update("update employees SET name = ? , salary = ? WHERE id = ? " , emp.getName(), emp.getSalary() , emp.getId()  );
	}

	@Override
	public int delete(Long id) {
 		return jdbcTemp.update("delete FROM employees WHERE id = ? " , id);
	}

}
