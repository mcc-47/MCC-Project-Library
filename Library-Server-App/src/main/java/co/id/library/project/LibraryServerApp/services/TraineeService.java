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
import co.id.library.project.LibraryServerApp.dto.TraineeDTO;
import co.id.library.project.LibraryServerApp.entities.Employee;
import co.id.library.project.LibraryServerApp.repositories.EmployeeRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TraineeService {

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    public TraineeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    //GET ALL TRAINEE
    public List<TraineeDTO> getTrainee() {
        List<Employee> employee = employeeRepository.findAll();
        List<TraineeDTO> pdds = new ArrayList<>();
        for (Employee e : employee) {
            if (e.getIdTrainer() != null && e.getTrainee().getStatusMcc().contains("trainee")) {
                TraineeDTO td = new TraineeDTO(
                        e.getIdMcc(),
                        e.getNama(),
                        e.getEmail(),
                        e.getJabatan(),
                        e.getTrainee().getBatch(),
                        e.getTrainee().getStatusMcc());
                pdds.add(td);
            }
        }
        return pdds;
    }
    
    //GET ALL ALUMNI
    public List<TraineeDTO> getAlumni() {
        List<Employee> employee = employeeRepository.findAll();
        List<TraineeDTO> pdds = new ArrayList<>();
        for (Employee e : employee) {
            if (e.getIdTrainer() != null && e.getTrainee().getStatusMcc().contains("lulus")) {
                TraineeDTO td = new TraineeDTO(
                        e.getIdMcc(),
                        e.getNama(),
                        e.getEmail(),
                        e.getJabatan(),
                        e.getTrainee().getBatch(),
                        e.getTrainee().getStatusMcc());
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
        Employee trainee = employeeRepository.getOne(id);
        trainee.setNama(employee.getNama());
        trainee.setEmail(employee.getEmail());
        trainee.setJabatan(employee.getJabatan());
        trainee.setTrainee(employee.getTrainee());
        trainee.setTrainee(employee.getTrainee());
        return employeeRepository.save(trainee);
    }
    
    //DELETE
    public void delete(Integer id){
        employeeRepository.deleteById(id);
    }

}
