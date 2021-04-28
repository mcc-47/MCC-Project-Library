/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.id.library.project.LibraryServerApp.services;

/**
 *
 * @author ASUS
 */
import co.id.library.project.LibraryServerApp.dto.TrainerDTO;
import co.id.library.project.LibraryServerApp.entities.Employee;
import co.id.library.project.LibraryServerApp.repositories.EmployeeRepository;
import java.util.ArrayList;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TrainerService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    public TrainerService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }
    
    //GET ALL
    public List<TrainerDTO> getTrainer() {
        List<Employee> employee = employeeRepository.findAll();
        List<TrainerDTO> pdds = new ArrayList<>();
        for (Employee e : employee) {
            if(e.getIdTrainer() ==  null && e.getIdKelas() != null) {
            TrainerDTO td = new TrainerDTO(
                    e.getIdMcc(),
                    e.getNama(),
                    e.getEmail(),
                    e.getIdKelas().getNamaKelas()
            );
            pdds.add(td);
        }
        }
        return pdds;
    }
    
    //GET BY ID
    public Employee getById(Integer IdMcc) {
        return employeeRepository.findById(IdMcc).get();
    }

    //UPDATE
    public Employee update(Integer id, Employee employee) throws Exception {
        if (!employeeRepository.existsById(employee.getIdMcc())) {

            throw new Exception("Employee unfound");
        }
        Employee trainer = employeeRepository.getOne(id);
        trainer.setNama(employee.getNama());
        trainer.setEmail(employee.getEmail());
        trainer.setIdKelas(employee.getIdKelas());
        return employeeRepository.save(trainer);
    }
    
    //DELETE
    public void delete(Integer id){
        employeeRepository.deleteById(id);
    }
}
