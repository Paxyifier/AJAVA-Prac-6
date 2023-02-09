package com.springbootTest.springBootDemo.api;

import com.springbootTest.springBootDemo.dao.EmployeeDAO;
import com.springbootTest.springBootDemo.model.Employee;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("api/v1/employee")
public class EmployeeAPI {
    public EmployeeDAO getEmployeeDAO() {
        if (employeeDAO == null){
            ApplicationContext ctx = new ClassPathXmlApplicationContext("config.xml");
            this.employeeDAO = ctx.getBean("employeeDao", EmployeeDAO.class);
        }
        return employeeDAO;
    }


    public EmployeeAPI() {
    }

    private EmployeeDAO employeeDAO;
    @GetMapping("all") //Get All
    ResponseEntity<List<Employee>> getAllEmployees(){

        return new ResponseEntity<>(getEmployeeDAO().getEmployees(),HttpStatus.OK);
    }
    @GetMapping("{id}") //Get One
    ResponseEntity<Employee> getEmployee(@PathVariable("id")Long id){
        return new ResponseEntity<>(getEmployeeDAO().getEmployee(id), HttpStatus.OK);
    }

    @PostMapping() //Create One
    ResponseEntity<String> createEmployee(@RequestBody Employee employee){
        return new ResponseEntity<>("Employee Created", HttpStatus.CREATED);
    }
    @PutMapping("{id}")  //Update One
    ResponseEntity<String> updateEmployee(@PathVariable("id") Long id, @RequestBody Employee e) {
        e.setId(id);
        return new ResponseEntity<>("Employee Edited", HttpStatus.OK);
    }

    @DeleteMapping("{id}") //Delete One
    ResponseEntity<String> deleteEmployee(@PathVariable("id") Long id) {
        getEmployeeDAO().deleteEmployee(id);
        return new ResponseEntity<>("User successfully deleted!", HttpStatus.OK);
    }
}
