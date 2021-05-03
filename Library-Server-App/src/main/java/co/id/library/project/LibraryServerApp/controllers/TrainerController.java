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
import co.id.library.project.LibraryServerApp.dto.TrainerDTO;
import co.id.library.project.LibraryServerApp.entities.Employee;
import co.id.library.project.LibraryServerApp.repositories.EmployeeRepository;
import co.id.library.project.LibraryServerApp.repositories.KelasRepository;
import co.id.library.project.LibraryServerApp.services.TrainerService;
import java.util.List;
import java.util.logging.Logger;
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
@RequestMapping ("trainer")
public class TrainerController {
    @Autowired
    TrainerService trainerService;
    
    @Autowired
    EmployeeRepository employeeRepository;
    
    @Autowired
    KelasRepository KelasRepository;
    
    
    TrainerDTO trainerDTO;
    
    @Autowired
    public TrainerController(TrainerService trainerService) {
        this.trainerService = trainerService;
    }
     
    //READ
    @GetMapping("/get-all")
    public List<TrainerDTO> getTrainerDTO(Authentication auth){
        return trainerService.getTrainer();

    }

   //GET BY ID
    @GetMapping("/{id}")
    public Employee getOneTrainer(Authentication auth, @PathVariable Integer id) {
        return trainerService.getById(id);
    }
    
    //UPDATE
    @PutMapping("/{id}")
    public Employee updateTrainer(Authentication auth, @PathVariable Integer id,
            @RequestBody Employee employee) throws Exception {
        return trainerService.update(id, employee);
    }
    
    //DELETE
     @DeleteMapping("/{id}")
    public String deleteTrainer(Authentication auth, @PathVariable Integer id){
        trainerService.delete(id);
        return "delete trainee";
    }
}
