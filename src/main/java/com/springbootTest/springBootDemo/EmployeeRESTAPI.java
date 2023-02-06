package com.springbootTest.springBootDemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeRESTAPI {
    @Autowired
    JpaRepository<Employee,Integer> repository;
    @GetMapping("/employees")
    public List<Employee> getAllEmployees(){
        return repository.findAll();
    }
    @GetMapping("/employee/{id}")
    public Employee getEmployee(@PathVariable Integer id){
        return repository.getById(id);
    }
    @PostMapping("/employee")
    public Employee createEmployee(@RequestBody Employee e){
        return repository.save(e);
    }
}
