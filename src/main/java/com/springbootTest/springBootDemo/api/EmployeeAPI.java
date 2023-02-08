package com.springbootTest.springBootDemo.api;

import com.springbootTest.springBootDemo.model.Employee;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeAPI {
    @GetMapping("api/v1/employee/{id}") //Get One
    Employee getEmployee(@PathVariable("id")int id){
        return new Employee();
    }
    @GetMapping("/employees") //Search
    public List<Employee> getEmployeeByProperty(@RequestParam(value = "id", required=false) String id,
                                                @RequestParam(value = "name", required=false) String name,
                                                @RequestParam(value = "designation", required=false) String designation,
                                                @RequestParam(value = "salary", required=false) int salary) {
        return null;

    }
    @PostMapping("/api/v1/employee") //Create One
    Employee createEmployee(@RequestBody Employee employee){
        return null;
    }
    @PutMapping("api/v1/employee/{id}")  //Update One
    Employee updateEmployee(@PathVariable("id") int id) {
        return null;
    }

    @DeleteMapping("api/v1/employee/{id}") //Delete One
    Employee deleteEmployee(@PathVariable("id") int id) {
        return null;
    }
}
