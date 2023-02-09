package com.springbootTest.springBootDemo.service;
import com.springbootTest.springBootDemo.model.Employee;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeRowMapper implements RowMapper<Employee> {

    public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Employee(rs.getLong(1),
                rs.getString(2),
                rs.getDouble(3));
    }
}
