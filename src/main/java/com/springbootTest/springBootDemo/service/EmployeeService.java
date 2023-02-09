package com.springbootTest.springBootDemo.service;

import com.springbootTest.springBootDemo.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EmployeeService {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public EmployeeService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public EmployeeService() {
    }

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }
    public int insertEmployee(Employee e){
        String query = "INSERT INTO employee (id, name, salary) values (?,?,?)";
        int result = this.jdbcTemplate.update(query,
                e.getId(),e.getName(),e.getSalary());
        return result;
    }
    public Employee getEmployee(Long id){
        String query ="SELECT * FROM employee WHERE id=?";
        List<Employee> ls = this.jdbcTemplate.query(query, new EmployeeRowMapper(),id);
        return ls.get(0);
    }
    public List<Employee> getEmployees(){
        String query ="SELECT * FROM employee";
        List<Employee> ls = this.jdbcTemplate.query(query, new EmployeeRowMapper());
        return ls;
    }
    public int updateEmployee(Long id, Employee eNew){
        String query = "UPDATE employee SET name=?,salary=? WHERE id=?";
        int result = this.jdbcTemplate.update(query,
                eNew.getName(),eNew.getSalary(),id);
        return result;
    }
    public int deleteEmployee(Long id){
        String query = "DELETE FROM employee WHERE id=?";
        int result = this.jdbcTemplate.update(query,id);
        return result;
    }
}
