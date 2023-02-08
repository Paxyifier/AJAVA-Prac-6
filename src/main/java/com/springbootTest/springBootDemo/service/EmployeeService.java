package com.springbootTest.springBootDemo.service;

import com.springbootTest.springBootDemo.model.Employee;

import java.util.List;
public interface EmployeeService {
    Employee createEmployee(Employee e);
    Employee getEmployeeById(Long id);
    List<Employee> getAllEmployees();
    Employee updateEmployee(Employee e);
    void deleteEmployee(Long id);
}
