package com.example.hr.Mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.example.hr.model.Employee;

public class EmployeeRowMapper implements RowMapper<Employee> {
    
    @Override
    public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Employee(rs.getLong("id") , rs.getString("name") , rs.getDouble("salary"));
    }
}
