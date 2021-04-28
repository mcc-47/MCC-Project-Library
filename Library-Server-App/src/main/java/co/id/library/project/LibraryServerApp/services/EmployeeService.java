/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.id.library.project.LibraryServerApp.services;

import co.id.library.project.LibraryServerApp.entities.Employee;
import co.id.library.project.LibraryServerApp.repositories.EmployeeRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ASUS
 */
@Service
public class EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;
    
    public List<Employee> listAll(){
        return employeeRepository.findAll();
    }
    
    public Employee getById(Integer idMcc){
        return employeeRepository.findById(idMcc).get();
    }
    
    public Employee create(Employee employee){
        return employeeRepository.save(employee);
    }
    
//    public Employee update(Integer idMcc, Employee employee){
//        Employee newEmp = employeeRepository.findById(idMcc).get();
//        newEmp.setEmployeeList(employeeList);
//        newEmp.setBirthDate(employees.getBirthDate());
//        newEmp.setGender(employees.getGender());
//        newEmp.setEmail(employees.getEmail());
//        return employeerepository.save(newEmp);
//    }
//    
//    public void delete(Integer employeeId){
//        employeerepository.deleteById(employeeId);
//    }
    
}
