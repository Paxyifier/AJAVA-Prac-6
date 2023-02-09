package com.springbootTest.springBootDemo.api;

import com.springbootTest.springBootDemo.service.EmployeeService;
import com.springbootTest.springBootDemo.model.Employee;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("api/v1/employee")
public class EmployeeAPI {
    private final EmployeeService employeeService;
    public EmployeeService getEmployeeDAO() {
        return employeeService;
    }
    public EmployeeAPI(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    @GetMapping("all") //Get All
    ResponseEntity<List<Employee>> getAllEmployees(){
        return new ResponseEntity<>(employeeService.getEmployees(),HttpStatus.OK);
    }
    @GetMapping("{id}") //Get One
    ResponseEntity<Employee> getEmployee(@PathVariable("id")Long id){
        return new ResponseEntity<>(employeeService.getEmployee(id), HttpStatus.OK);
    }

    @PostMapping() //Create One
    ResponseEntity<String> createEmployee(@RequestBody Employee employee){
        employeeService.insertEmployee(employee);
        return new ResponseEntity<>("Employee Created", HttpStatus.CREATED);
    }
    @PutMapping("{id}")  //Update One
    ResponseEntity<String> updateEmployee(@PathVariable("id") Long id, @RequestBody Employee e) {
        e.setId(id);
        employeeService.updateEmployee(id,e);
        return new ResponseEntity<>("Employee Edited", HttpStatus.OK);
    }

    @DeleteMapping("{id}") //Delete One
    ResponseEntity<String> deleteEmployee(@PathVariable("id") Long id) {
        employeeService.deleteEmployee(id);
        return new ResponseEntity<>("User successfully deleted!", HttpStatus.OK);
    }
}
