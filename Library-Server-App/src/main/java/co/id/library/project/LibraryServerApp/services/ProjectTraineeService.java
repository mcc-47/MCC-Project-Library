/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.id.library.project.LibraryServerApp.services;

import co.id.library.project.LibraryServerApp.dto.ProjectTrainee;
import co.id.library.project.LibraryServerApp.entities.Project;
import co.id.library.project.LibraryServerApp.entities.Status;
import co.id.library.project.LibraryServerApp.entities.Trainee;
import co.id.library.project.LibraryServerApp.repositories.ProjectRepository;
import co.id.library.project.LibraryServerApp.repositories.TraineeRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ASUS
 */
@Service
public class ProjectTraineeService {
    ProjectTrainee projectTrainee;
    
    Project project;
    
    @Autowired
    ProjectRepository projectRepository;
    
    @Autowired
    TraineeRepository traineeRepository;
        
    public String registerProject (ProjectTrainee projectTrainee){
        projectRepository.save(new Project(
                projectTrainee.getIdProject(),
                projectTrainee.getJudul(),
                projectTrainee.getDeskripsi(),
                projectTrainee.getErd(),
                projectTrainee.getUml(),
                projectTrainee.getSkema(),
                projectTrainee.getLink(),
                new Status(1)
        ));
        for( Integer anggota : projectTrainee.getIdMcc() ){
            Trainee addProject = traineeRepository.findById(anggota).get();
            addProject.setIdProject( new Project(projectTrainee.getIdProject()));
            traineeRepository.save(addProject);
        }        
        return "Registrasi Project Berhasil";
    }
    
}
