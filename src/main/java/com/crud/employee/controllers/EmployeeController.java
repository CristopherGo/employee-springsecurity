package com.crud.employee.controllers;

import java.util.ArrayList;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.crud.employee.services.EmployeeService;
import com.crud.employee.model.EmployeeModel;

@RestController
@RequestMapping("/APIrest-Employee")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping()
    public ArrayList<EmployeeModel> getEmployee() {
        return employeeService.getEmployee();
    }

    @GetMapping(path = "/login")
    public String login() {
        return "hello Admin!!";
    }

    @PostMapping()
    public EmployeeModel saveEmployee(@RequestBody EmployeeModel employee) {
        return this.employeeService.saveEmployee(employee);
    }

    @GetMapping(path = "/{id}")
    public Optional<EmployeeModel> findByID(@PathVariable("id") Long id) {
        return this.employeeService.findEmployeeById(id);

    }

    @DeleteMapping(path = "/{id}")
    public String deleteByID(@PathVariable("id") Long id) {
        boolean ok = this.employeeService.deleteEmployee(id);
        if (ok) {
            return "Deleted Employee:  " + id;
        } else {
            return "Could not deleted: " + id;
        }
    }
}
