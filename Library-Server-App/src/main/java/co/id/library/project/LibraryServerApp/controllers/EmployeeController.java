/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.id.library.project.LibraryServerApp.controllers;

import co.id.library.project.LibraryServerApp.entities.Employee;
import co.id.library.project.LibraryServerApp.services.EmployeeService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author ASUS
 */
@RestController
@RequestMapping("/employee")
public class EmployeeController {
    
    @Autowired
    EmployeeService employeeService;
    
    public EmployeeController() {
    }
    
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    
    @GetMapping
    public String hello(){
        return "bismillah";
    }
    @GetMapping("/list")
    public List<Employee> showEmployee(){
        return employeeService.listAll();
    }
    
    @GetMapping("/get-one/{id}")
    public Employee getOneEmployee(@PathVariable Integer id){
        return employeeService.getById(id);
    }
}
