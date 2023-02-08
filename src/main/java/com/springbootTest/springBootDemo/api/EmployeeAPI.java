package com.springbootTest.springBootDemo.api;

import com.springbootTest.springBootDemo.model.Employee;
import com.springbootTest.springBootDemo.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/employee")
public class EmployeeAPI {
    public EmployeeService getEmployeeService() {
        return employeeService;
    }

    public void setEmployeeService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    public EmployeeAPI(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    private EmployeeService employeeService;
    @GetMapping("all") //Get All
    ResponseEntity<List<Employee>> getAllEmployees(){
        return new ResponseEntity<>(employeeService.getAllEmployees(),HttpStatus.OK);
    }
    @GetMapping("{id}") //Get One
    ResponseEntity<Employee> getEmployee(@PathVariable("id")Long id){
        return new ResponseEntity<>(employeeService.getEmployeeById(id), HttpStatus.OK);
    }

    @PostMapping() //Create One
    ResponseEntity<Employee> createEmployee(@RequestBody Employee employee){
        return new ResponseEntity<>(employeeService.createEmployee(employee), HttpStatus.CREATED);
    }
    @PutMapping("{id}")  //Update One
    ResponseEntity<Employee> updateEmployee(@PathVariable("id") Long id, @RequestBody Employee e) {
        e.setId(id);
        return new ResponseEntity<>(employeeService.updateEmployee(e), HttpStatus.OK);
    }

    @DeleteMapping("{id}") //Delete One
    ResponseEntity<String> deleteEmployee(@PathVariable("id") Long id) {
        employeeService.deleteEmployee(id);
        return new ResponseEntity<>("User successfully deleted!", HttpStatus.OK);
    }
}
