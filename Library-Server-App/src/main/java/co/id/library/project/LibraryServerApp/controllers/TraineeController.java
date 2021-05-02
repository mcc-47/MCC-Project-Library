/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.id.library.project.LibraryServerApp.controllers;

/**
 *
 * @author ASUS
 */
import co.id.library.project.LibraryServerApp.dto.TraineeDTO;
import co.id.library.project.LibraryServerApp.entities.Employee;
import co.id.library.project.LibraryServerApp.repositories.EmployeeRepository;
import co.id.library.project.LibraryServerApp.repositories.TraineeRepository;
import co.id.library.project.LibraryServerApp.services.TraineeService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("trainee")
public class TraineeController {

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    TraineeRepository traineeRepository;

    @Autowired
    TraineeService traineeService;

    @Autowired
    public TraineeController(TraineeService traineeService) {
        this.traineeService = traineeService;
    }

    //GET ALL
    @GetMapping("/get-all")
    public List<TraineeDTO> getTraineeDTO(Authentication auth) {
        return traineeService.getTrainee();

    }
    
    //GET BY ID
    @GetMapping("/{id}")
    public Employee getOneTrainee(Authentication auth, @PathVariable Integer id) {
        return traineeService.getById(id);
    }
    
    //UPDATE
    @PutMapping("/{id}")
    public Employee updateTrainee(Authentication auth, @PathVariable Integer id,
            @RequestBody Employee employee) throws Exception {
        return traineeService.update(id, employee);
    }
    
    //DELETE
     @DeleteMapping("/{id}")
    public String deleteTrainee(Authentication auth, @PathVariable Integer id){
        traineeService.delete(id);
        return "delete trainee";
    }
}
